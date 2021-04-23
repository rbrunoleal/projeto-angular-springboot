package com.example.workshop.controller.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.workshop.model.Cidade;
import com.example.workshop.model.Endereco;

public class EnderecoDto {
	
	private long id;
	private String rua;
	private String bairro;
	private String numero;
	private Cidade cidade;
	
	
	public EnderecoDto(long id, String rua, String bairro, String numero, Cidade cidade) {
		this.id = id;
		this.rua = rua;
		this.bairro = bairro;
		this.numero = numero;
		this.cidade = cidade;
	}

	public long getId() {
		return id;
	}
	
	public String getRua() {
		return rua;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public Cidade getCidade() {
		return cidade;
	}
	
	public static List<EnderecoDto> converteList(List<Endereco> valores) {
		List<EnderecoDto> dto = new ArrayList<EnderecoDto>();
		valores.forEach(v->{
			dto.add(new EnderecoDto(v.getId(), v.getRua(), v.getBairro(), v.getNumero(), v.getCidade()));
		});
		return dto;
	}

	public static EnderecoDto converte(Endereco v) {
		return new EnderecoDto(v.getId(), v.getRua(), v.getBairro(), v.getNumero(), v.getCidade());
	}
	
	

}
