package com.prjLupi.livros.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prjLupi.livros.entities.Livros;
import com.prjLupi.livros.repository.LivrosRepository;
@Service
public class LivrosServices {
	private final LivrosRepository livrosRepository;
	
	@Autowired
	public LivrosServices(LivrosRepository livrosRepository) {
		this.livrosRepository = livrosRepository;
	}

	public Livros saveLivros(Livros livros) {
		return livrosRepository.save(livros);
	}
	public Livros getLivrosById(Long id) {
		return livrosRepository.findById(id).orElse(null);	
	}
	public List<Livros> getAllLivros(){
		return livrosRepository.findAll();
	}
	public void deleteLivros(Long id) {
		livrosRepository.deleteById(null);
	}

	public Livros updateLivros(Long id, Livros livros) {
		// TODO Auto-generated method stub
		return null;
	}
}
