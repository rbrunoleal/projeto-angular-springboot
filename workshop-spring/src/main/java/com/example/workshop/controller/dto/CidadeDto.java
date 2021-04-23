package com.example.workshop.controller.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.workshop.model.Cidade;
import com.example.workshop.model.Estado;

public class CidadeDto {
	
	private long id;
	private String nomeCidade;
	private Estado estado;
	
	
	public CidadeDto(long id, String nomeCidade, Estado estado) {
		this.id = id;
		this.nomeCidade = nomeCidade;
		this.estado = estado;
	}

	public long getId() {
		return id;
	}
	
	public String getNomeCidade() {
		return nomeCidade;
	}
	
	public Estado getEstado() {
		return estado;
	}
	
	public static List<CidadeDto> converteList(List<Cidade> valores) {
		List<CidadeDto> dto = new ArrayList<CidadeDto>();
		valores.forEach(v->{
			dto.add(new CidadeDto(v.getId(), v.getDescricao(), v.getEstado()));
		});
		return dto;
	}

	public static CidadeDto converte(Cidade v) {
		return new CidadeDto(v.getId(), v.getDescricao(), v.getEstado());
	}
	
	
	

}
