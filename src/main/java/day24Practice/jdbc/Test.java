package day24Practice.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class Test implements CommandLineRunner {
	@Autowired 
	CategoryManager cm;
//	PracticeCRUD p;
//	NamedParameter np;
//	Delete d;
	
	public void run (String...strings) {
//		cm.updateCatDesc("abc", "Camera");
//		cm.listCategories();
//		cm.showCategoryCount();
		cm.listCatObjects();
//		p.listCategories();
//		System.out.println();
//		p.listCategoriesMap();
//		p.update("Camera", "cam");
//		np.addCategory("sw", "Stopwatch");
//		np.addCategory("gc", "Graphics Card");
//		d.delete("sw");
//		d.deleteNp("gc");
	}
	public static void main(String[] args) {
		SpringApplication.run(Test.class, args);
	}
}