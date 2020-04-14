package br.com.fiap.triagem.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_PACIENTE")
@SequenceGenerator(name="paciente", sequenceName="SQ_TB_PACIENTE", allocationSize = 1)
public class Paciente {

	@Id
	@Column(name="cd_paciente")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "paciente")
	private int codigo;
	
	@Column(name="nm_paciente", length = 50, nullable = false)
	private String nome;
	
	@Column(name="nr_cpf", length = 11, nullable = false)
	private String cpf;
	
	@OneToMany(mappedBy = "paciente", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<Internacao> internacoes;

	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "TB_PACIENTE_PLANO",
	joinColumns = @JoinColumn(name = "cd_paciente"),
	inverseJoinColumns = @JoinColumn(name = "cd_plano_saude"))
	private List<PlanoSaude> planos;

	
	public Paciente(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}

	public Paciente() {
		super();
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Internacao> getInternacao() {
		return internacoes;
	}

	public void setInternacao(List<Internacao> internacoes) {
		this.internacoes = internacoes;
	}

	public List<PlanoSaude> getPlanos() {
		return planos;
	}

	public void setPlanos(List<PlanoSaude> planos) {
		this.planos = planos;
	}
	
}
