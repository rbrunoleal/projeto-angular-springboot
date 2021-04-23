package com.example.workshop.controller;

import com.example.workshop.controller.dto.CidadeDto;
import com.example.workshop.controller.form.CidadeForm;
import com.example.workshop.data.CidadeRepository;
import com.example.workshop.data.EstadoRepository;
import com.example.workshop.model.Cidade;
import com.example.workshop.model.Estado;

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

@RestController
@RequestMapping("/cidades")
public class CidadeController {
    
    @Autowired
    private CidadeRepository cidadeRepository;
    
    @Autowired
    private EstadoRepository estadoRepository;
    
    @GetMapping
    public List<CidadeDto>listar() {
        return CidadeDto.converteList(this.cidadeRepository.findAll());
    }
    
    @PostMapping
    @Transactional
    public CidadeDto Salvar(@RequestBody CidadeForm novaCidade) {
        Cidade cidade = CidadeForm.converte(novaCidade, this.estadoRepository);
    	this.cidadeRepository.save(cidade);
    	return CidadeDto.converte(cidade);
    }  
    
    @GetMapping("/{id}")
    public CidadeDto Buscar(@PathVariable Long id) {
    	return CidadeDto.converte(this.cidadeRepository.findById(id).get());
    }
    
    @PutMapping("/{id}")
    @Transactional
    public CidadeDto editar(@PathVariable Long id, @RequestBody CidadeForm cidadeEdit) {
    	Cidade cidade = this.cidadeRepository.findById(id).get();
    	Estado estado = this.estadoRepository.findById(cidadeEdit.getIdEstado()).get(); 
    	cidade.setDescricao(cidadeEdit.getNomeCidade());
    	cidade.setEstado(estado);
    	return CidadeDto.converte(cidade);
    }
    
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable long id) {
    	this.cidadeRepository.deleteById(id);
    }
    
    @GetMapping("/estado/{id}")
    public List<CidadeDto> buscaPorEstado(@PathVariable long id) {
    	return CidadeDto.converteList(this.cidadeRepository.findAllByEstado_id(id));
    }
    
    
    
    
}
