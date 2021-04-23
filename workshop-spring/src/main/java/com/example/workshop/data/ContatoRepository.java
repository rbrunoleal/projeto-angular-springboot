package com.example.workshop.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.workshop.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
