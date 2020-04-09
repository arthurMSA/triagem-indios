package br.com.fiap.triagem.dao;

import br.com.fiap.triagem.exception.CommitException;
import br.com.fiap.triagem.exception.NoDataException;

public interface GenericDAO<T, K> {
	
	void cadastrar(T entidade);
	
	void atualizar(T entidade);
	
	T pesquisar(K chave) throws NoDataException;
	
	void deletar(K chave) throws NoDataException;
	
	void commit() throws CommitException;
}
