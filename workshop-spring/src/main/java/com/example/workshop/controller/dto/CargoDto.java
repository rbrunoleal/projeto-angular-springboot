package com.example.workshop.controller.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.workshop.model.Cargo;
import com.example.workshop.model.Departamento;

public class CargoDto {

	private Long id;
	private String descricao;
	private Departamento departamento;
	
	
	public CargoDto(Long id, String descricao, Departamento departamento) {
		this.id = id;
		this.descricao = descricao;
		this.departamento = departamento;
	}

	public Long getId() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	

	public Departamento getDepartamento() {
		return departamento;
	}

	public static List<CargoDto> converteList(List<Cargo> valores) {
		List<CargoDto> dto = new ArrayList<CargoDto>();
		valores.forEach(v->{
			dto.add(new CargoDto(v.getId(),v.getDescricao(), v.getDepartamento()));
		});
		return dto;
	}

	public static CargoDto converte(Cargo v) {
		return new CargoDto(v.getId(), v.getDescricao(), v.getDepartamento());
	}
	
	
}
