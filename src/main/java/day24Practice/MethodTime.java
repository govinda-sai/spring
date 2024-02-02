package day24Practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class MethodTime implements CommandLineRunner {
	@Autowired
	Methods methods;
	@Override
	public void run (String...strings) {
		if (methods != null) {
			methods.print();
			System.out.println(methods.add(20, 30));
			System.out.println(methods.multiply(232, 23929));
		} else {
			System.out.println("Methods are null");
		}
	}
	public static void main(String[] args) {
		SpringApplication.run(MethodTime.class, args);
	}
}