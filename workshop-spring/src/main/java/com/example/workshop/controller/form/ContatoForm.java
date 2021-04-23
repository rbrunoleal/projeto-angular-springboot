package com.example.workshop.controller.form;

import com.example.workshop.data.FuncionarioRepository;
import com.example.workshop.model.Contato;
import com.example.workshop.model.Funcionario;
import com.example.workshop.model.TipoContato;

public class ContatoForm {
	
	private Long id_funcionario;
	private String campo;
	private char tipo;
	
	public Long getId_funcionario() {
		return id_funcionario;
	}
	
	public void setId_funcionario(Long id_funcionario) {
		this.id_funcionario = id_funcionario;
	}
	
	public String getCampo() {
		return campo;
	}
	
	public void setCampo(String campo) {
		this.campo = campo;
	}
	
	public char getTipo() {
		return tipo;
	}
	
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	
	public static TipoContato converteTipo(char valor) {
		if(valor == 'c' || valor == 'C')
			return TipoContato.CELULAR;
		if(valor == 't' || valor == 'T')
			return TipoContato.TELEFONE;
		if(valor == 'e' || valor == 'E')
			return TipoContato.EMAIL;
		return TipoContato.NAO_ESPECIFICADO;
	}
	
	public static Contato converte(ContatoForm valorNew, FuncionarioRepository funcionarioRep) {
		Funcionario funcionario = funcionarioRep.findById(valorNew.getId_funcionario()).get();
		return new Contato(funcionario, valorNew.getCampo(), ContatoForm.converteTipo(valorNew.getTipo()));
	}
	
	
	

}
