package com.devmarcio.springBootJpa.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.devmarcio.springBootJpa.entities.Category;

@Component
public class CategoryRepository {

	// Map muito importante aprender fica a dica
	// Ele é uma coleção de pares(chave e valor)
	// No java o Map é uma Interface, temos que instanciar 
	// Para guardar na memória
	Map<Long, Category> map = new HashMap<>();
	
	// Método para salvar um objeto do tipo categoria, que informamos para o método
	public void save(Category obj) {
		// Para inserir no map do java o método é o (put(chave, valor))
		map.put(obj.getId(), obj);
	}
	
	// Serve para informar um id ele retorna uma categoria referente ao id informado
	public Category findById(Long id) {
		// Para encontra por id e só pesquisar com o map se tem o id que foi informado
		// Como o método .get()
		return map.get(id);
	}
	
	// Retorna a lista com todas as categorias do banco de dados
	public List<Category> findAll(){
		
		// O construtor map.values() pega todos os valores do tipo Category
		return new ArrayList<Category>(map.values());
	}
}
