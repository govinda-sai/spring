package day27;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestTransaction implements CommandLineRunner {
	@Autowired 
	Transaction t;
	
	@Autowired 
	SwapPrices swap;
	
	public void run (String...strings) throws Exception {
		// 1
//		t.insertSale();
//		t.deleteSale1(13);
//		t.deleteSale2(139, 5);
		
		// 2 
		swap.swapPrices(105, 109);
	}
	public static void main(String[] args) {
		SpringApplication.run(TestTransaction.class, args);
	}
}