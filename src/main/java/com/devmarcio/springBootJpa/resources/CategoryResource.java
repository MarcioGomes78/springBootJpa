package com.devmarcio.springBootJpa.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devmarcio.springBootJpa.entities.Category;

// Essa annotation: Seve para que o framework reconhecça essa classe como um recurso Rest
@RestController
// Serve para fazer o mapeamneto de url e define o caminho pelo qual o recurso REST vai repponder
@RequestMapping(value = "/categories")
public class CategoryResource {

	// Serve para fazer uma requisição GET no caminho do RequestMapping("/categories")
	@GetMapping
	// E vai ser chamado esse método
	// O tipo Generic: ResponseEntity é especial porque ele encapsula uma resosta http 
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = new ArrayList<Category>();
		// Adicionar na lista
		list.add(new Category(1L, "Eletronics"));
		list.add(new Category(2L, "Books"));
		// Para retornar uma resposta usamos o ResponseEntity 
		// com o .ok(): que é o método que instancia uma repsosta do código 200 do protocolo http
		// O corpo da resposta vai ser o obj list
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/{id}")
	// Para encontrar pelo id usa-se uma Category e não um a List<Category>
	// O @PathVariable reconhece o id pelo (/1, /2, ...)
	public ResponseEntity<Category> findById(@PathVariable Long id){
		// Instance 
		Category cat = new Category(1L, "Eletronics");
		return ResponseEntity.ok().body(cat);
	}
}
