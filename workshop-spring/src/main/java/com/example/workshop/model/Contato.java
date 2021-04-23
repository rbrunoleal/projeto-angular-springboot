package com.example.workshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="contatos")
public class Contato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "id_funcionario")
	private Funcionario funcionario;
	@Column(length = 110, nullable = false)
	private String numero;
	@Enumerated(EnumType.STRING)
	private TipoContato tipo;
	
	public Contato() {}

	public Contato(Funcionario funcionario, String numero, TipoContato tipo) {
		this.funcionario = funcionario;
		this.numero = numero;
		this.tipo = tipo;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public TipoContato getTipo() {
		return tipo;
	}

	public void setTipo(TipoContato tipo) {
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}
	
	
	
	

}
