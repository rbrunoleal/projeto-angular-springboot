package com.example.workshop.controller.form;

import com.example.workshop.model.Projeto;

public class ProjetoForm {
	
	private String nome;
	private String dataInicio;
	private String nomeContratante;
	
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
	public String getNomeContratante() {
		return nomeContratante;
	}
	public void setNomeContratante(String nomeContratante) {
		this.nomeContratante = nomeContratante;
	}
	
	public static Projeto converte(ProjetoForm valorNew) {
		return new Projeto(valorNew.getNome(), valorNew.getDataInicio(), valorNew.getNomeContratante());
	}

}
