package com.example.workshop.controller.form;

import java.util.List;

import com.example.workshop.data.CargoRepository;
import com.example.workshop.data.EnderecoRepository;
import com.example.workshop.model.Cargo;
import com.example.workshop.model.Endereco;
import com.example.workshop.model.Funcionario;
import com.example.workshop.model.Projeto;

public class FuncionarioForm {

	private String nome_funcionario;
	private String cpf_funcionario;
	private Long idCargo;
	private Long idEndereco;
	
	
	public Long getIdCargo() {
		return idCargo;
	}

	public Long getIdEndereco() {
		return idEndereco;
	}

	public String getNome_funcionario() {
		return nome_funcionario;
	}
	
	public void setNome_funcionario(String nome_funcionario) {
		this.nome_funcionario = nome_funcionario;
	}
	
	public String getCpf_funcionario() {
		return cpf_funcionario;
	}
	
	public void setCpf_funcionario(String cpf_funcionario) {
		this.cpf_funcionario = cpf_funcionario;
	}
	
	public static Funcionario converte(FuncionarioForm valorNew, EnderecoRepository enderecoRep, CargoRepository cargoRep) {
		Cargo cargo = cargoRep.findById(valorNew.getIdCargo()).get();
		Endereco endereco = enderecoRep.findById(valorNew.getIdEndereco()).get();
		
		return new Funcionario(valorNew.getNome_funcionario(), valorNew.getCpf_funcionario(), cargo, endereco);
	}
	
	
	
}
