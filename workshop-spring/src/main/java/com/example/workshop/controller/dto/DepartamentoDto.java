package com.example.workshop.controller.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.workshop.model.Departamento;

public class DepartamentoDto {

	private long id;
	private String descricao;
	
	
	public DepartamentoDto(long id, String nomeDepartamento) {
		this.id = id;
		this.descricao = nomeDepartamento;
	}
	
	public long getId() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static List<DepartamentoDto> converteList(List<Departamento> valores) {
		List<DepartamentoDto> dto = new ArrayList<DepartamentoDto>();
		valores.forEach(v->{
			dto.add(new DepartamentoDto(v.getId(), v.getDescricao()));
		});
		return dto;
	}

	public static DepartamentoDto converte(Departamento v) {
		return new DepartamentoDto(v.getId(), v.getDescricao());
	}
	
	
}
