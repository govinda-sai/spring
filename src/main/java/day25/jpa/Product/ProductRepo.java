package day25.jpa.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
	List<Product> findAllByNameContaining(String name);
	List<Product> findAllByNameStartsWith(String name);
}