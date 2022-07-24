# Projeto Básico - Java web no Spring Boot
###### DevSuperior - sua carreira dev com fundamento de ensino superior

## O que você vai aprender
- Criar um projeto básico Java web no Spring Boot e Maven
- Introdução prática a injeção de dependência no Spring Boot
- Introdução prática a REST / web services
- Introdução prática ao Spring Data JPA com banco H2

## Passos

- Criar projeto no STS

- Criar a entidade Category

- Criar CategoryResource

```java
@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	@GetMapping
	public ResponseEntity<...> findAll() {
		...
		return ResponseEntity.ok().body(...);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<...> findById(@PathVariable Long id) {
		...
		return ResponseEntity.ok().body(...);
	}
}
```

- Criar CategoryRepository

```java
@Component
public class CategoryRepository {
	public void save(Category obj) {
		...
	}
	public Category findById(Long id) {
		...
	}
	
	public List<Category> findAll() {
		...
	}
}
```

- Implementar CommandLineRunner para instanciar categorias no startup da aplicação. Usar o mecanismo de **injeção de dependência** do Spring Boot para obter uma instância de CategoryRepository.

```java
Category cat1 = new Category(1L, "Electronics");
Category cat2 = new Category(2L, "Books");
```

- Acrescentar entidade Product ao projeto

```java
Category cat1 = new Category(1L, "Electronics");
Category cat2 = new Category(2L, "Books");
Product p1 = new Product(1L, "TV", 2200.00, cat1);
Product p2 = new Product(2L, "Domain Driven Design", 120.00, cat2);
Product p3 = new Product(3L, "PS5", 2800.00, cat1);
Product p4 = new Product(4L, "Docker", 100.00, cat2);
cat1.getProducts().addAll(Arrays.asList(p1, p3));
cat2.getProducts().addAll(Arrays.asList(p2, p4));
```

- Acrescentar as configurações do H2 em application.properties

```yml
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

- Fazer os mapeamentos objeto-relacional

```java
@Entity
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Double price;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
```
- Retirar os ID's das instâncias em CommandLineRunner (deixar como null)
- Trocar o código dos repositories: usar JpaRepository<Entity, ID>

## Diagramas
### Modelo conceitual
![myImage](https://github.com/devsuperior/aulao005/raw/master/domain-model.png)
### Instância
![myImage](https://github.com/devsuperior/aulao005/raw/master/domain-instance.png)
