package practiceIoC;

import java.util.List;

import org.springframework.stereotype.Component;

//@Component
public class PythonCatalog implements Catalog {
	
	public PythonCatalog () {
		System.out.println("Python no args contructor");
	}
	
	@Override
	public List<String> getBooks() {
		return List.of("Python CookBook", "Fluent Python");
	}
}