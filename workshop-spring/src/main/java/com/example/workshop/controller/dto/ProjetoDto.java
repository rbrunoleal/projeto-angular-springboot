package com.example.workshop.controller.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.workshop.model.Projeto;

public class ProjetoDto {
	
	private Long id;
	private String nome;
	private String dataInicio;
	private String nomeContratante;
	
	
	public ProjetoDto(Long id, String nome, String dataInicio, String nomeContratante) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.nomeContratante = nomeContratante;
	}

	public Long getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}


	public String getDataInicio() {
		return dataInicio;
	}


	public String getNomeContratante() {
		return nomeContratante;
	}
	
	public static List<ProjetoDto> converteList(List<Projeto> valores) {
		List<ProjetoDto> dto = new ArrayList<ProjetoDto>();
		valores.forEach(v->{
			dto.add(new ProjetoDto(v.getId(), v.getNome(), v.getDataInicio(), v.getContratante()));
		});
		return dto;
	}

	public static ProjetoDto converte(Projeto v) {
		return new ProjetoDto(v.getId(), v.getNome(), v.getDataInicio(), v.getContratante());
	}
	
	
	
	

}
