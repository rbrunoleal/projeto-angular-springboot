package com.example.workshop.model;

import java.util.List;

import javax.persistence.*;        

@Entity
@Table(name="funcionarios")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "nome_funcionario", length = 150, nullable = false)
    private String nome;
    @Column(name = "cpf_funcionario",length = 11, nullable = false)
    private String cpf;
    @ManyToOne
    @JoinColumn(name = "id_cargo")
    private Cargo cargo;
    @ManyToOne
    @JoinColumn(name="id_endereco")
    private Endereco endereco;
    
    @ManyToMany
    @JoinTable(
    		name = "participa_de",
    		joinColumns = {
    				@JoinColumn(name= "id_funcionario", referencedColumnName = "id")},
    				inverseJoinColumns= {
    						@JoinColumn(name="id_projeto", referencedColumnName = "id")
    				}
    		
    		)
    private List<Projeto> projeto;
    

	Funcionario() {}
    
    public Funcionario(String nome, String cpf, Cargo cargo, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.endereco = endereco;
    }


    public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Long getId() {
		return id;
	}


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }    
    
    public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Projeto> getProjeto() {
		return projeto;
	}

	public void setProjeto(List<Projeto> projeto) {
		this.projeto = projeto;
	}
	
	public void addProjeto(List<Projeto> projeto) {
		this.projeto.addAll(projeto);
	}
	
	
}
