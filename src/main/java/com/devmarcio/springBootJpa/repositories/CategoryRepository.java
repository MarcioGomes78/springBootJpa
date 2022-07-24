package com.devmarcio.springBootJpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devmarcio.springBootJpa.entities.Category;

// Reconhece que uma classe vai participar de uma injeção de dependecia
//@Component
// Repository é uma classe pecial que acessa os dados
// Ela é resposável de manipular os dados referentea aquela entidade (Category)
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	
	/*
	// Map é uma coleção muito importante aprender fica a dica
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
	*/
}
