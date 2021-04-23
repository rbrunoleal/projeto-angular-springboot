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

import com.example.workshop.controller.dto.CargoDto;
import com.example.workshop.controller.form.CargoForm;
import com.example.workshop.data.CargoRepository;
import com.example.workshop.data.DepartamentoRepository;
import com.example.workshop.model.Cargo;

@RestController
@RequestMapping("/cargos")
public class CargoController {
	
	@Autowired
	private CargoRepository cargoRepository;
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@GetMapping
	public List<CargoDto> listar(){
		List<Cargo> cargos = this.cargoRepository.findAll();
		
		return CargoDto.converteList(cargos);
	}
	
	@PostMapping
	@Transactional
	public CargoDto salvar(@RequestBody CargoForm cargoNew) {
		System.out.println("aqui");
		Cargo cargo = CargoForm.converte(cargoNew, this.departamentoRepository);
		this.cargoRepository.save(cargo);
		return CargoDto.converte(cargo);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public CargoDto editar(@PathVariable Long id, @RequestBody CargoForm cargoEdit) {
		Cargo cargo = this.cargoRepository.findById(id).get();
		cargo.setDescricao(cargoEdit.getDescricao());
		return CargoDto.converte(cargo);
	}
	
	@GetMapping("/{id}")
	public CargoDto buscar(@PathVariable Long id) {
		return CargoDto.converte(this.cargoRepository.findById(id).get());
	}
	
	@DeleteMapping("/{id}")
	public void Deletar(@PathVariable Long id) {
		this.cargoRepository.deleteById(id);
	}
	
	@GetMapping("/departamento/{id}")
	public List<CargoDto> buscarPorDepartamento(@PathVariable Long id) {
		List<Cargo> cargolist = this.cargoRepository.findAllByDepartamento_id(id);
		return CargoDto.converteList(cargolist);
	}

}
