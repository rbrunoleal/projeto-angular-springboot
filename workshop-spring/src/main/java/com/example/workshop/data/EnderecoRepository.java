package com.example.workshop.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.workshop.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
