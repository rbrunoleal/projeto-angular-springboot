package com.example.workshop.controller.form;

import java.util.ArrayList;
import java.util.List;

import com.example.workshop.data.CargoRepository;
import com.example.workshop.data.CidadeRepository;
import com.example.workshop.data.FuncionarioRepository;
import com.example.workshop.data.ProjetoRepository;
import com.example.workshop.model.Cargo;
import com.example.workshop.model.Cidade;
import com.example.workshop.model.Contato;
import com.example.workshop.model.Endereco;
import com.example.workshop.model.Funcionario;
import com.example.workshop.model.Projeto;

public class FuncionarioFullForm {

	private String nome_funcionario;
	private String cpf_funcionario;
	private Long idCargo;
	private EnderecoForm endereco;
	private List<ContatoForm> contatos;
	private List<Long> idProjetos;
	
	
	
	public List<Long> getIdProjetos() {
		return idProjetos;
	}

	public void setIdProjetos(List<Long> idProjetos) {
		this.idProjetos = idProjetos;
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
	
	public Long getIdCargo() {
		return idCargo;
	}
	
	public void setIdCargo(Long idCargo) {
		this.idCargo = idCargo;
	}
	
	public EnderecoForm getEndereco() {
		return endereco;
	}
	
	public void setEndereco(EnderecoForm endereco) {
		this.endereco = endereco;
	}
	
	public List<ContatoForm> getContatos() {
		return contatos;
	}
	
	public void setContatos(List<ContatoForm> contatos) {
		this.contatos = contatos;
	}
	
	public static Endereco converteEndereco(FuncionarioFullForm valorNew, CidadeRepository cidadeRep) {
		Cidade cidade = cidadeRep.findById(valorNew.endereco.getIdCidade()).get();		
		return new Endereco(valorNew.endereco.getRua(), valorNew.endereco.getBairro(), valorNew.endereco.getNumero(), cidade);
	}
	
	public static Funcionario converteFuncionario(FuncionarioFullForm valorNew, Endereco endereco, CargoRepository cargoRep) {
		Cargo cargo = cargoRep.findById(valorNew.getIdCargo()).get();
		return new Funcionario(valorNew.getNome_funcionario(), valorNew.getCpf_funcionario(), cargo, endereco);
	}

	public static List<Contato> converteContatos(FuncionarioFullForm funcionarioNew, Funcionario funcionario) {
		List<Contato> contatos = new ArrayList<Contato>();
		funcionarioNew.contatos.forEach(contato -> {
			contatos.add(new Contato(funcionario, contato.getCampo(), ContatoForm.converteTipo(contato.getTipo())));
		});
		
		return contatos;
	}

	public static void adiionaProjetos(Funcionario funcionario, FuncionarioFullForm funcionarioNew, ProjetoRepository projetoRepository) {
		List<Projeto> projetos = new ArrayList<Projeto>();
		funcionarioNew.idProjetos.forEach(idProjeto -> {
			Projeto projeto = projetoRepository.findById(idProjeto).get();
			projetos.add(projeto);
		});
		
		funcionario.setProjeto(projetos);
	}
	
	
	
	
}
