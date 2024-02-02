package day27Practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestTransaction implements CommandLineRunner {
	@Autowired 
	TransactionDemo td;
	
	public void run (String...strings) throws Exception {
		
	}
	public static void main(String[] args) {
		SpringApplication.run(TestTransaction.class, args);
	}
}