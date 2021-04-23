package com.example.workshop.controller.form;

import com.example.workshop.data.CidadeRepository;
import com.example.workshop.model.Cidade;
import com.example.workshop.model.Endereco;

public class EnderecoForm {
	
	private String rua;
	private String bairro;
	private String numero;
	private Long idCidade;
	
	public String getRua() {
		return rua;
	}
	
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public Long getIdCidade() {
		return idCidade;
	}
	
	public void setIdCidade(Long cidade) {
		this.idCidade = cidade;
	}
	
	public static Endereco converte(EnderecoForm valorNew, CidadeRepository cidadeRep){
		Cidade cidade = cidadeRep.findById(valorNew.getIdCidade()).get();
		return new Endereco(valorNew.getRua(), valorNew.getBairro(), valorNew.getNumero(), cidade);
	}
	
	
	

}
