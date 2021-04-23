package com.example.workshop.controller.form;

import com.example.workshop.data.EstadoRepository;
import com.example.workshop.model.Cidade;
import com.example.workshop.model.Estado;

public class CidadeForm {
	
	private String nomeCidade;
	private Long idEstado;
	
	public String getNomeCidade() {
		return nomeCidade;
	}
	
	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}
	
	public Long getIdEstado() {
		return idEstado;
	}
	
	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}
	
	public static Cidade converte(CidadeForm valorNew, EstadoRepository estadoRep) {
		Estado estado = estadoRep.findById(valorNew.idEstado).get();
		return new Cidade(valorNew.getNomeCidade(), estado);
	}
	
	
	

}
