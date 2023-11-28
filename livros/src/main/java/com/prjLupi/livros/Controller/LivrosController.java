package com.prjLupi.livros.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prjLupi.livros.entities.Livros;
import com.prjLupi.livros.services.LivrosServices;

@RestController
@RequestMapping("/Livros")
public class LivrosController {
	private final LivrosServices livrosServices = null;

	@GetMapping("/home")
	public String paginaInicial() {
		return "index";
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Livros> getJogo(@PathVariable Long id) {
		Livros livros = livrosServices.getLivrosById(id);
		if (livros != null) {
			return ResponseEntity.ok(livros);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public Livros createJogo(@RequestBody Livros livros) {
		return livrosServices.saveLivros(livros);
	}

	// Utilizando o ResponseEntity e RequestEntity
	@GetMapping
	public ResponseEntity<List<Livros>> getAllLivros(RequestEntity<Void> requestEntity) {
		String method = requestEntity.getMethod().name();
		String contentType = requestEntity.getHeaders().getContentType().toString();
		List<Livros> livros = livrosServices.getAllLivros();
		return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
				.body(livros);
	}

	@PutMapping("/{id}")
	public Livros updateGame(@PathVariable Long id, @RequestBody Livros livros) {
		return livrosServices.updateLivros(id, livros);
	}

	@DeleteMapping("/{id}")
	public void deleteJogo(@PathVariable Long id) {
		livrosServices.deleteLivros(id);
	}

}