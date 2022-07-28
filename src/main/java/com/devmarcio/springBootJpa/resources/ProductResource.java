package com.devmarcio.springBootJpa.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devmarcio.springBootJpa.entities.Product;
import com.devmarcio.springBootJpa.services.ProductService;

// Essa annotation: Seve para que o framework reconhecça essa classe como um recurso Rest
@RestController
// Serve para fazer o mapeamneto de url e define o caminho pelo qual o recurso REST vai repponder
@RequestMapping(value = "/products")
public class ProductResource {

	// Sempre que instanciar um objeto ProductResource o Autowired vai
	// automaticamente obter
	// Uma instancia do ProductRepository que está na dependencia

	// Serve para fazer uma injeção de dependecias
	// para ter uma instacia do ProductRepository dentro do ProductResource
	// Usamos o Autowired
	// @Autowired
	// private ProductRepository categoryRepository;
	// Serve para fazer uma requisição GET no caminho do
	// RequestMapping("/categories")
	// @GetMapping
	// E vai ser chamado esse método
	// O tipo Generic: ResponseEntity é especial porque ele encapsula uma resosta
	// http
	// public ResponseEntity<List<Product>> findAll(){
	// List<Product> list = categoryRepository.findAll();
	// Para retornar uma resposta usamos o ResponseEntity
	// com o .ok(): que é o método que instancia uma repsosta do código 200 do
	// protocolo http
	// O corpo da resposta vai ser o obj list
	// return ResponseEntity.ok().body(list);
	// }

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/{id}")
	// Para encontrar pelo id usa-se uma Product e não um a List<Product>
	// O @PathVariable reconhece o id pelo (localhots:8080/categories/1)
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		// Instance
		Product obj = productService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
