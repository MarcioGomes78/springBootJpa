	package com.devmarcio.springBootJpa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devmarcio.springBootJpa.entities.Category;
import com.devmarcio.springBootJpa.repositories.CategoryRepository;

// Essa annotation: Seve para que o framework reconhecça essa classe como um recurso Rest
@RestController
// Serve para fazer o mapeamneto de url e define o caminho pelo qual o recurso REST vai repponder
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	// Sempre que instanciar um objeto CategoryResource o Autowired vai automaticamente obter 
	// Uma instancia do CategoryRepository que está na dependencia 

	// Serve para fazer uma injeção de dependecias
	// para ter uma instacia do CategoryRepository dentro do CategoryResource
	// Usamos o Autowired 
	@Autowired
	private CategoryRepository categoryRepository;
	// Serve para fazer uma requisição GET no caminho do RequestMapping("/categories")
	@GetMapping
	// E vai ser chamado esse método
	// O tipo Generic: ResponseEntity é especial porque ele encapsula uma resosta http 
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = categoryRepository.findAll();
		// Para retornar uma resposta usamos o ResponseEntity 
		// com o .ok(): que é o método que instancia uma repsosta do código 200 do protocolo http
		// O corpo da resposta vai ser o obj list
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/{id}")
	// Para encontrar pelo id usa-se uma Category e não um a List<Category>
	// O @PathVariable reconhece o id pelo (localhots:8080/categories/1)
	public ResponseEntity<Category> findById(@PathVariable Long id){
		// Instance 
		Category cat = categoryRepository.findById(id).get();
		return ResponseEntity.ok().body(cat);
	}
}
