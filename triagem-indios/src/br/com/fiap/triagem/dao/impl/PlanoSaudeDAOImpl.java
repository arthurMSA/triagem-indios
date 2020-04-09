package br.com.fiap.triagem.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.triagem.dao.PlanoSaudeDAO;
import br.com.fiap.triagem.entity.PlanoSaude;

public class PlanoSaudeDAOImpl extends GenericDAOImpl<PlanoSaude, Integer> implements PlanoSaudeDAO{
	public PlanoSaudeDAOImpl(EntityManager em) {
		super(em);
	}
}