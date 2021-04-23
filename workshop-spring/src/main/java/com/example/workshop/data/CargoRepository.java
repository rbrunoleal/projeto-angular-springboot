package com.example.workshop.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.workshop.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

	public Cargo findByDescricao(String cargo);

	public Cargo findByDepartamento_id(Long id);

	public List<Cargo> findAllByDepartamento_id(Long id);

}
