package br.com.fiap.triagem.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_INTERNACAO")
@SequenceGenerator(name="internacao", sequenceName = "SQ_TB_INTERNACAO", allocationSize = 1)
public class Internacao {

	@Id
	@Column(name="cd_internacao")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "internacao")
	private int codigo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name= "dt_internacao", nullable = false)
	private Calendar dtInternacao;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_risco", nullable=false)
	private Risco risco;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_alta")
	private Calendar dtAlta;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "cd_paciente")
	private Paciente paciente;
	
	public Internacao() {
		super();
	}
	public Internacao(Calendar dtInternacao, Risco risco, Calendar dtAlta, Paciente paciente) {
		super();
		this.dtInternacao = dtInternacao;
		this.risco = risco;
		this.dtAlta = dtAlta;
		this.paciente = paciente;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Calendar getDtInternacao() {
		return dtInternacao;
	}
	public void setDtInternacao(Calendar dtInternacao) {
		this.dtInternacao = dtInternacao;
	}
	public Risco getRisco() {
		return risco;
	}
	public void setRisco(Risco risco) {
		this.risco = risco;
	}
	public Calendar getDtAlta() {
		return dtAlta;
	}
	public void setDtAlta(Calendar dtAlta) {
		this.dtAlta = dtAlta;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
}