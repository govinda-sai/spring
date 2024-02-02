package day25.jpa.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
//@SpringBootApplication
public class TestProduct implements CommandLineRunner {
	@Autowired
	ProductRepo pr;

	public void listProducts() {
		for (var v : pr.findAll()) {
			System.out.println(v);
		}
	}

	public void addProduct(String name, Double price, Integer qoh) {
		Product product = new Product();
		product.setName(name);
		product.setPrice(price);
		product.setQoh(qoh);

		pr.save(product);
	}

	public void updateProduct(Integer prodid, String remarks) {
		var product = pr.findById(prodid);
		if (product.isPresent()) {
			var getProduct = product.get();
			getProduct.setRemarks(remarks);
			pr.save(getProduct);
		} else {
			System.out.println("product not found");
		}
	}

	public void deleteProduct(Integer prodid) {
		pr.deleteById(prodid);
	}

	public void run(String... strings) {
//		listProducts();
//		addProduct("Macbook Air", 120000.0, 7);
//		updateProduct(109, "Laptop");
//		deleteProduct(107);
//		pr.findAllProductsContaining("Pavilion");
		
		List<Product> productList = pr.findAllByNameContaining("Pavilion");
		List<Product> productsStartsWith = pr.findAllByNameStartsWith("hp");
		for(var v : productList) {
			System.out.println(v);
		}
		System.out.println();
		for(var v : productsStartsWith) {
			System.out.println(v);
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(TestProduct.class, args);
	}
}