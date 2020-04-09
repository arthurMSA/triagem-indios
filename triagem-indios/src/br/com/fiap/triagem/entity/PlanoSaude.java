package br.com.fiap.triagem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_PLANO_SAUDE")
@SequenceGenerator(name="planosaude", sequenceName="SQ_TB_PLANOSAUDE", allocationSize=1)
public class PlanoSaude {
	
	@Id
	@Column(name="cd_plano_saude")
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="planosaude")
	private int codigo;
	
	@Column(name="nm_plano_saude")
	private String nome;
	
	@Column(name="cd_convenio")
	private Convenio convenio;
	
	@Enumerated(EnumType.STRING)
	@Column(name="nm_modalidade")
	private ModalidadePlano modalidade;
}