package com.example.workshop.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.workshop.controller.dto.ContatoDto;
import com.example.workshop.controller.form.ContatoForm;
import com.example.workshop.data.ContatoRepository;
import com.example.workshop.data.FuncionarioRepository;
import com.example.workshop.model.Contato;
import com.example.workshop.model.Funcionario;

@RestController
@RequestMapping("/contatos")
public class ContatoController {
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	
	@GetMapping
	public List<ContatoDto> listar(){
		return ContatoDto.converteList(this.contatoRepository.findAll());
	}
	
	@PostMapping
	@Transactional
	public ContatoDto salvar(@RequestBody ContatoForm contatoNew) {
		Contato contato = ContatoForm.converte(contatoNew, funcionarioRepository);
		this.contatoRepository.save(contato);
		return ContatoDto.converte(contato);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ContatoDto editar(@PathVariable Long id, @RequestBody ContatoForm contatoEdit) {
		Contato contato = this.contatoRepository.findById(id).get();
		Funcionario funcionario = this.funcionarioRepository.findById(contatoEdit.getId_funcionario()).get();
		contato.setFuncionario(funcionario);
		contato.setNumero(contatoEdit.getCampo());
		contato.setTipo(ContatoForm.converteTipo(contatoEdit.getTipo()));
		
		return ContatoDto.converte(contato);
	}
	
	@GetMapping("/{id}")
	public ContatoDto buscar(@PathVariable long id) {
		return ContatoDto.converte(this.contatoRepository.findById(id).get());
	}
	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		this.contatoRepository.deleteById(id);
	}
	
	
	
	
	
	

}
