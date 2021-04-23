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

import com.example.workshop.controller.dto.DepartamentoDto;
import com.example.workshop.controller.form.DepartamentoForm;
import com.example.workshop.data.DepartamentoRepository;
import com.example.workshop.model.Departamento;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	@GetMapping
	public List<DepartamentoDto>listar() {
		return DepartamentoDto.converteList(this.departamentoRepository.findAll());
	}
	
	@PostMapping
	@Transactional
	public DepartamentoDto salvar(@RequestBody DepartamentoForm departamentoNew) {
		Departamento departamento = DepartamentoForm.converte(departamentoNew); 
		this.departamentoRepository.save(departamento);
		return DepartamentoDto.converte(departamento);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public DepartamentoDto editar(@PathVariable Long id, @RequestBody DepartamentoForm departamentoEdit) {
		Departamento departamento = this.departamentoRepository.findById(id).get();
		departamento.setDescricao(departamentoEdit.getDescricao());
		return DepartamentoDto.converte(departamento);
	}
	
	@GetMapping("/{id}")
	public DepartamentoDto buscar(@PathVariable Long id) {
		return DepartamentoDto.converte(this.departamentoRepository.findById(id).get());
	}
	
	@DeleteMapping("/{id}")
	public void Deletar(@PathVariable Long id) {
		this.departamentoRepository.deleteById(id);
	}

}

