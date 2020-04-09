package br.com.fiap.triagem.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.triagem.dao.LeitoDAO;
import br.com.fiap.triagem.entity.Leito;


public class LeitoDAOImpl extends GenericDAOImpl<Leito, Integer> implements LeitoDAO{
	public LeitoDAOImpl(EntityManager em) {
		super(em);
	}
}

