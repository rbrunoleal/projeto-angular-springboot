package com.example.workshop.controller.form;

import com.example.workshop.model.Estado;

public class EstadoForm {
	
	private String descricao;
	
	
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static Estado converte(EstadoForm valorNew) {
		return new Estado(valorNew.getDescricao());
	}
	

}
