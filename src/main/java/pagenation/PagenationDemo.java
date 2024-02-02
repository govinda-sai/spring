package pagenation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class PagenationDemo implements CommandLineRunner {
	@Autowired
	SaleRepo sr;
	
	public void printPage(int pageno) {
		var page = sr.findAll(PageRequest.of(pageno, 3)); 
		/* pageno -> is page number, 3 is number of rows per page */
		System.out.println(page.getNumber() + "/" + page.getTotalPages());
		for(var v : page) {
			System.out.println(v);
		}
	}
	
	/* Sorting */
	public void sortingPrice() {
		for(var v : sr.findAll(Sort.by("amount").descending().and(Sort.by("qty")))) {
			System.out.println(v);
		}
	}
	
	/* Query By Example */ 
	public void printSales(int qty, int amount) {
		Sale s = new Sale();
		s.setQty(qty);
		s.setAmount(amount);
		
		var matcher = ExampleMatcher.matchingAny().withIgnoreCase("invno", "transdate", "prodid");
		
		for(var v : sr.findAll(Example.of(s, matcher))) {
			System.out.println(v);
		}
	}
	
	public void run(String...strings) {
		printPage(0);
		sortingPrice();
		printSales(1, 100);
	}
	public static void main(String[] args) {
		SpringApplication.run(PagenationDemo.class, args);
	}
}