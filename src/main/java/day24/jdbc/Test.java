package day24.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
//@SpringBootApplication
public class Test implements CommandLineRunner {
	@Autowired
	ListProducts lp;
	
	@Override 
	public void run(String...strings) {
		lp.listProducts();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Test.class, args);
	}
}