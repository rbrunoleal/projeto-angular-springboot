package com.example.workshop.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="projetos")
public class Projeto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nome_projeto",nullable = false, unique = true)
	private String nome;
	@Column(name = "data_inicio", nullable = false)
	private String dataInicio;
	@Column(name = "nome_contratante", nullable = false)
	private String contratante;
	
	public Projeto() {}
	
	public Projeto(String nome, String dataInicio, String contratante){
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.contratante = contratante;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getContratante() {
		return contratante;
	}

	public void setContratante(String contratante) {
		this.contratante = contratante;
	}

	public Long getId() {
		return id;
	}
	
	

}
