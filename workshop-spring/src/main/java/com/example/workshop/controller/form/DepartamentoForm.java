package com.example.workshop.controller.form;

import com.example.workshop.model.Departamento;

public class DepartamentoForm {

	private String descricao;

	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static Departamento converte(DepartamentoForm valorNew) {
		return new Departamento(valorNew.getDescricao());
	}
	
	
}
