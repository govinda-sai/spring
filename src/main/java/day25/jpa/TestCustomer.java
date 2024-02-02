package day25.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class TestCustomer implements CommandLineRunner {
	@Autowired 
	CustomerRepo cr;
	
	public void insert(String name, String email, String mobile, String gender) {
		Customer c = new Customer();
		c.setName(name);
		c.setEmail(email);
		c.setGender(gender);
		cr.save(c);
	}
	
	public void listCustomers() {
		for(var v : cr.findAll()) {
			System.out.println(v);
		}
	}
	
	public void updateCustomer(Integer id, String name) {
		var cFound = cr.findById(id);
		if(cFound.isPresent()) {
			var customer = cFound.get();
			customer.setName(name);
			cr.save(customer);
		}
	}
	
	public void deleteCustomer(Integer id) {
		cr.deleteById(3);
	}
	
	@Override
	public void run(String... args) throws Exception {
//		insert("Drake", "drake@gmail.com", "", "male");
//		insert("Travis", "travis@gmail.com", "", "male");
//		updateCustomer(2, "Ye");
//		deleteCustomer(10);
//		deleteCustomer(3);
		listCustomers();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TestCustomer.class, args);
	}
}