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

import com.example.workshop.controller.dto.EnderecoDto;
import com.example.workshop.controller.form.EnderecoForm;
import com.example.workshop.data.CidadeRepository;
import com.example.workshop.data.EnderecoRepository;
import com.example.workshop.model.Cidade;
import com.example.workshop.model.Endereco;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@GetMapping
	public List<EnderecoDto> listar(){
		return EnderecoDto.converteList(this.enderecoRepository.findAll());
	}
	
	@PostMapping
	@Transactional
	public EnderecoDto salvar(@RequestBody EnderecoForm enderecoNew) {
		Endereco endereco = EnderecoForm.converte(enderecoNew, cidadeRepository);
		this.enderecoRepository.save(endereco);
		return EnderecoDto.converte(endereco);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public EnderecoDto editar(@PathVariable Long id, @RequestBody EnderecoForm enderecoEdit) {
		Endereco endereco = this.enderecoRepository.findById(id).get();
		Cidade cidade = this.cidadeRepository.findById(enderecoEdit.getIdCidade()).get();
		endereco.setRua(enderecoEdit.getRua());
		endereco.setNumero(enderecoEdit.getNumero());
		endereco.setCidade(cidade);
		endereco.setBairro(enderecoEdit.getBairro());
		return EnderecoDto.converte(endereco);
	}
	
	@GetMapping("/{id}")
	public EnderecoDto buscar(@PathVariable long id) {
		return EnderecoDto.converte(this.enderecoRepository.findById(id).get());
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		this.enderecoRepository.deleteById(id);
	}
	
	
	

}
