package day25;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component 
//@SpringBootApplication
public class TestDeleteSale implements CommandLineRunner {
	@Autowired 
	DeleteSale delete;
	
	public void run(String...strings) {
		delete.deleteSale(5, 1);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TestDeleteSale.class, args);
	}
}