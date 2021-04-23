package com.example.workshop.controller.form;

import com.example.workshop.data.DepartamentoRepository;
import com.example.workshop.model.Cargo;
import com.example.workshop.model.Departamento;

public class CargoForm {

	private String descricao;
	private String departamento;
	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public static Cargo converte(CargoForm valorNew, DepartamentoRepository departamentoRepository) {
		Departamento departamento = departamentoRepository.findByDescricao(valorNew.departamento);
		return new Cargo(valorNew.getDescricao(), departamento);
	}
	
	
	
}
