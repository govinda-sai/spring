package ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PrintCatalog implements CommandLineRunner {
	@Autowired
	private Catalog catalog; // object is created automatically
	public void run (String...s) throws Exception {
		for(var v : catalog.getBooks()) {
			System.out.println(v);
		}
	}
}