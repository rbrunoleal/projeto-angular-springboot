package com.example.workshop.data;

import com.example.workshop.model.Cidade;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{
       public Cidade findByDescricao(String estado);

	public Optional<Cidade> findByEstado_id(long id);

	public List<Cidade> findAllByEstado_id(long id);
}
