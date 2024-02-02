package practiceIoC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class PrintCatalog implements CommandLineRunner {
	@Autowired (required = false)/* it won't throw an error even if there is no compoenent */
	Catalog catalog; // field based Autowiring
//	@Autowired (required = false)
//	@Qualifier (value = "pythonCatalog") 
	/* @Qualifier annotation makes a component qualified for dependency injection (D.I)
	 * this makes the component qualified even though there's a @Primary component */
//	Catalog catalog1;
	
//	@Autowired (required = false)
//	@Qualifier (value = "pythonCatalog")
//	Catalog catalog2;
	
//	@Override
//	public void run (String... args) {
//		System.out.println(catalog1.hashCode());
//		System.out.println(catalog2.hashCode());
//		for (var j : catalog1.getBooks()) {
//			System.out.println(j);
//		}
//		for(var p : catalog2.getBooks()) {
//			System.out.println(p);
//		}
//	}
	
	@Override
	public void run(String... args) throws Exception {
//		for(var v : catalog.getBooks()) {
//			System.out.println(v);
//		}
	}
	public static void main(String[] args) {
		SpringApplication.run(PrintCatalog.class, args);
	}

}