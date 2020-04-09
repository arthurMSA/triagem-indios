package br.com.fiap.triagem.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@Enumerated(EnumType.STRING)
	@Column(name="nm_modalidade")
	private ModalidadePlano modalidade;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cd_convenio", nullable = false)
	private Convenio convenio;

	
	
	
	public PlanoSaude() {
		super();
	}

	public PlanoSaude(String nome, ModalidadePlano modalidade, Convenio convenio) {
		super();
		this.nome = nome;
		this.modalidade = modalidade;
		this.convenio = convenio;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ModalidadePlano getModalidade() {
		return modalidade;
	}

	public void setModalidade(ModalidadePlano modalidade) {
		this.modalidade = modalidade;
	}

	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}
	
	
	
}