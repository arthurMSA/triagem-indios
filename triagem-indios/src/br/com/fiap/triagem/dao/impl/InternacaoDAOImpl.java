package br.com.fiap.triagem.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.triagem.dao.InternacaoDAO;
import br.com.fiap.triagem.entity.Convenio;
import br.com.fiap.triagem.entity.Internacao;

public class InternacaoDAOImpl extends GenericDAOImpl<Internacao, Integer> implements InternacaoDAO{
	public InternacaoDAOImpl(EntityManager em) {
		super(em);
	}
}
