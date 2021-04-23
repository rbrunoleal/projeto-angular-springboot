package com.example.workshop.controller;

import java.util.ArrayList;
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

import com.example.workshop.controller.dto.ProjetoDto;
import com.example.workshop.controller.form.AddFuncionarioForm;
import com.example.workshop.controller.form.ProjetoForm;
import com.example.workshop.data.FuncionarioRepository;
import com.example.workshop.data.ProjetoRepository;
import com.example.workshop.model.Funcionario;
import com.example.workshop.model.Projeto;

@RestController
@RequestMapping("projetos")
public class ProjetoController {

	@Autowired
	private ProjetoRepository projetoRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@GetMapping
	public List<ProjetoDto> listar() {
		return ProjetoDto.converteList(this.projetoRepository.findAll());

	}
	
	@PostMapping
	@Transactional
	public ProjetoDto Salvar(@RequestBody ProjetoForm projetoNew) {
		Projeto projeto = ProjetoForm.converte(projetoNew); 
				this.projetoRepository.save(projeto);
		return ProjetoDto.converte(projeto);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ProjetoDto editar(@PathVariable Long id, @RequestBody ProjetoForm projetoEdit) {
		Projeto projeto = this.projetoRepository.findById(id).get();
		projeto.setNome(projetoEdit.getNome());
		projeto.setDataInicio(projetoEdit.getDataInicio());
		projeto.setContratante(projetoEdit.getNomeContratante());
		
		return ProjetoDto.converte(projeto);
	}
	
	@GetMapping("/{id}")
	public Projeto buscar(@PathVariable long id) {
		return this.projetoRepository.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	public void Deletar(@PathVariable Long id) {
		this.projetoRepository.deleteById(id);
	}
	
	@PostMapping("{idProjeto}/add/funcionario")
	@Transactional
	public Funcionario teste(@PathVariable Long idProjeto, @RequestBody AddFuncionarioForm addFuncionario) {
		Projeto projeto = this.projetoRepository.findById(idProjeto).get();
		Funcionario funcionario = this.funcionarioRepository.findById(addFuncionario.getIdFuncionario()).get();
		List<Projeto> projetoList = new ArrayList<>();
		projetoList.add(projeto);
		funcionario.addProjeto(projetoList);
		return funcionario;
	}
	
	
	
}
