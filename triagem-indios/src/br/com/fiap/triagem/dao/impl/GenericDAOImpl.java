package br.com.fiap.triagem.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.triagem.dao.GenericDAO;
import br.com.fiap.triagem.exception.CommitException;
import br.com.fiap.triagem.exception.NoDataException;

public abstract class GenericDAOImpl<T, K> implements GenericDAO<T, K> {

	private EntityManager em;
	
	private Class<T> classe;
	
	@SuppressWarnings("all")
    public GenericDAOImpl(EntityManager em) {
        this.em = em;
        this.classe = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
	
	@Override
	public void cadastrar(T entidade) {
		em.persist(entidade);
	}

	@Override
	public void atualizar(T entidade) {
		em.merge(entidade);
	}

	@Override
	public T pesquisar(K chave) throws NoDataException {
		T entidade = em.find(classe, chave);
		if(entidade == null) {
			throw new NoDataException();
		}
		return entidade;
	}

	@Override
	public void deletar(K chave) throws NoDataException {
		T entidade = pesquisar(chave);
		em.remove(entidade);
		
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new CommitException();
		}
	}

}
