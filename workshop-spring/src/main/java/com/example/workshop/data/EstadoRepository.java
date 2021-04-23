package com.example.workshop.data;

import com.example.workshop.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Long>{
       public Estado findByDescricao(String estado);
}
