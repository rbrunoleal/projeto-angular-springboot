package com.example.workshop.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.workshop.model.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

	public Projeto findBynome(String nomeProjeto);

}
