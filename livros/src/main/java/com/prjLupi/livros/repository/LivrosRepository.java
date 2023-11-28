package com.prjLupi.livros.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prjLupi.livros.entities.Livros;

import jakarta.persistence.Id;

public interface LivrosRepository extends JpaRepository<Livros, Id>{

	Optional<Livros> findById(Long id);

}
