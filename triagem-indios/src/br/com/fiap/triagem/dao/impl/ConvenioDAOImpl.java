package br.com.fiap.triagem.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.triagem.dao.ConvenioDAO;
import br.com.fiap.triagem.entity.Convenio;

public class ConvenioDAOImpl extends GenericDAOImpl<Convenio, Integer> implements ConvenioDAO{
	public ConvenioDAOImpl(EntityManager em) {
		super(em);
	}
}
