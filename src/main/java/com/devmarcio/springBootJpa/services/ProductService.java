package com.devmarcio.springBootJpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmarcio.springBootJpa.entities.Product;
import com.devmarcio.springBootJpa.repositories.ProductRepository;

// O @Service é uma especializaçõa do annotation @Component do Spring Boot.
// Ele serve para registrar a classe como um componente de que vai participar do 
// mecanismo de injeção de dependência do Spring Boot.

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	public Product findById(Long id) {
		return productRepository.findById(id).get();
	}
}
