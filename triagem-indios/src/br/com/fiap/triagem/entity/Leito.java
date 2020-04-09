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
@Table(name="TB_LEITO")
@SequenceGenerator(name="leito", sequenceName="SQ_TB_LEITO", allocationSize=1)
public class Leito {
	
	@Id
	@Column(name="cd_leito")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "leito")
	private int codigo;
	
	@Column(name="nr_leito", nullable=false)
	private int numLeito;
	
	@Column(name="nr_andar", nullable=false)
	private int numAndar;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_tipo", nullable=false)
	private Tipo tipo;

	public Leito() {
		super();
	}

	public Leito(int numLeito, int numAndar, Tipo tipo) {
		super();
		this.numLeito = numLeito;
		this.numAndar = numAndar;
		this.tipo = tipo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getNumLeito() {
		return numLeito;
	}

	public void setNumLeito(int numLeito) {
		this.numLeito = numLeito;
	}

	public int getNumAndar() {
		return numAndar;
	}

	public void setNumAndar(int numAndar) {
		this.numAndar = numAndar;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

}
