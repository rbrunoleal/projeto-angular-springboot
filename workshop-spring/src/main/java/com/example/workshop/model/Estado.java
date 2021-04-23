package com.example.workshop.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="estados")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String descricao;    
    @OneToMany(mappedBy = "estado")
    private List<Cidade> cidades;

	/* Este bloco de comando estava fazendo com que as consultas de cidades ficassem em loop
	 * 
	 * public List<Cidade> getCidades() { return cidades; }
	 * 
	 * public void setCidades(List<Cidade> cidades) { this.cidades = cidades; }
	 */
    
    public Estado() {}
    
    public Estado(String descricao) {
	this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
