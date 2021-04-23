package com.example.workshop.controller;

import com.example.workshop.controller.dto.EstadoDto;
import com.example.workshop.controller.form.EstadoForm;
import com.example.workshop.data.EstadoRepository;
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
@RequestMapping("/estados")
public class EstadoController {
    
    @Autowired
    private EstadoRepository estadoRepository;
    
    @GetMapping
    public List<EstadoDto>listar() {
        return EstadoDto.converteList(this.estadoRepository.findAll());
    }
    
    @PostMapping
    @Transactional
    public EstadoDto Salvar(@RequestBody EstadoForm novoEstado) {
    	Estado estado = EstadoForm.converte(novoEstado);
    	this.estadoRepository.save(estado);
    	return EstadoDto.converte(estado);
    }  
    
    @PutMapping("/{id}")
    @Transactional
    public EstadoDto editar(@PathVariable Long id, @RequestBody EstadoForm estadoEdit) {
    	Estado estado = this.estadoRepository.findById(id).get();
    	estado.setDescricao(estadoEdit.getDescricao());
    	return EstadoDto.converte(estado);
    }
    
    @GetMapping("/{id}")
    public EstadoDto Buscar(@PathVariable Long id) {
            return EstadoDto.converte(this.estadoRepository.findById(id).get());
    }
    
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable long id) {
    	this.estadoRepository.deleteById(id);
    }
    
}
