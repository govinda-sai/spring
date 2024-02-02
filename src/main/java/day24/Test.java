package day24;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class Test implements CommandLineRunner {
	@Autowired
	Methods m;

	public void run(String... strings) {
		try {
			m.print();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
//		System.out.println(m.add(30, 20));
//		System.out.println(m.divide(30, 5));
	}

	public static void main(String[] args) {
		SpringApplication.run(Test.class, args);
	}
}