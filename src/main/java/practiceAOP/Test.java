package practiceAOP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class Test implements CommandLineRunner {
	
	@Autowired 
	Order order;
	
	public void run (String...strings) {
		try {
			order.placeOrder();
			order.getOrderStatus(11);
			order.cancelOrder();
		} catch (Exception e) {
			System.out.println("Error occurred");
		}
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Test.class, args);
	}
}
