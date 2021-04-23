package com.example.workshop.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.workshop.model.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

	public Departamento findByDescricao(String departamento);

}
