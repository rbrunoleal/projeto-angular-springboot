package com.example.workshop.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.workshop.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	public Funcionario findBycpf(String cpfFuncioanario);

}
