package com.prjLupi.livros.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_Livro")
public class Livros {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descricao;
	
	private String isbn;
	
	public Livros() {
	
	}
	public Livros(Long id, String descricao, String isbn) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.isbn = isbn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return descricao;
	}

	public void setName(String name) {
		this.descricao = name;
	}

	public String getPlataform() {
		return isbn;
	}

	public void setPlataform(String plataform) {
		this.isbn = isbn;
	}

	

	
}
