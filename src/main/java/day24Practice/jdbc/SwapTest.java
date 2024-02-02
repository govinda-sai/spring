package day24Practice.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class SwapTest implements CommandLineRunner {
	@Autowired 
	SwapDescription sd;
	
	public void run(String...strings) {
		sd.swap("cam", "gc");
	}
	public static void main(String[] args) {
		SpringApplication.run(SwapTest.class, args);
	}
}