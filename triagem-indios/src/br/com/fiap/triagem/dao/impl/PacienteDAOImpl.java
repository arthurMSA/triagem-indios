package br.com.fiap.triagem.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.triagem.dao.PacienteDAO;
import br.com.fiap.triagem.entity.Paciente;

public class PacienteDAOImpl extends GenericDAOImpl<Paciente, Integer> implements PacienteDAO{
	public PacienteDAOImpl(EntityManager em) {
		super(em);
	}
}
