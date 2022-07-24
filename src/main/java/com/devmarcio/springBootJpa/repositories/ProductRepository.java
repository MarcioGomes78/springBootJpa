package com.devmarcio.springBootJpa.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.devmarcio.springBootJpa.entities.Product;

// Reconhece que uma classe vai participar de uma injeção de dependecia
@Component
// Repository é uma classe pecial que acessa os dados
// Ela é resposável de manipular os dados referentea aquela entidade (Product)
public class ProductRepository {

	// Map é uma coleção muito importante aprender fica a dica
	// Ele é uma coleção de pares(chave e valor)
	// No java o Map é uma Interface, temos que instanciar 
	// Para guardar na memória
	Map<Long, Product> map = new HashMap<>();
	
	// Método para salvar um objeto do tipo categoria, que informamos para o método
	public void save(Product obj) {
		// Para inserir no map do java o método é o (put(chave, valor))
		map.put(obj.getId(), obj);
	}
	
	// Serve para informar um id ele retorna uma categoria referente ao id informado
	public Product findById(Long id) {
		// Para encontra por id e só pesquisar com o map se tem o id que foi informado
		// Como o método .get()
		return map.get(id);
	}
	
	// Retorna a lista com todas as categorias do banco de dados
	public List<Product> findAll(){
		
		// O construtor map.values() pega todos os valores do tipo Product
		return new ArrayList<Product>(map.values());
	}
}
