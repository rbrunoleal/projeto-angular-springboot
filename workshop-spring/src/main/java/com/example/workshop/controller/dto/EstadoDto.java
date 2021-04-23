package com.example.workshop.controller.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.workshop.model.Estado;

public class EstadoDto {
	
	private Long id;
	private String descricao;
	
	
	public EstadoDto(Long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static List<EstadoDto> converteList(List<Estado> valores) {
		List<EstadoDto> dto = new ArrayList<EstadoDto>();
		valores.forEach(v->{
			dto.add(new EstadoDto(v.getId(), v.getDescricao()));
		});
		return dto;
	}

	public static EstadoDto converte(Estado v) {
		return new EstadoDto(v.getId(), v.getDescricao());
	}
	
	

}
