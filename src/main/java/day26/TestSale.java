package day26;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

//@Component
//@SpringBootApplication
public class TestSale implements CommandLineRunner {
	@Autowired
	SaleRepo sr;

	public void deleteByids(List<Integer> invnos) {
		sr.deleteAllById(invnos);
	}

	@Override
	public void run(String... args) throws Exception {
		for (var v : sr.findAll()) {
			System.out.println(v);
		}
		
		// 1
		for (var v : sr.findAllByQtyBetween(2, 3)) {
			System.out.println(v);
		}
		
		// 2
		for (var v : sr.findAllByProdid(100)) {
			System.out.println(v);
		}
		
		// 3
		for (var v : sr.saleByMonth(5)) {
			System.out.println(v);
		}
		
		// 4 
		for (var v : sr.findAllByQtyAndProdid(3, 100)) {
			System.out.println(v);
		}
		
		// 5 
		deleteByids(List.of(201, 202, 203));
		
		// 6 
		System.out.println(sr.countSalesByProdid(101));
		
		// 7 
		for (var v : sr.productNameQtyList()) {
			System.out.printf("%-30s %-10d\n", v.getProdName(), v.getSumQty());
		}
		
		// 8 
		System.out.println(sr.countSalesByMonthAndYear(2, 2022));
	}

	public static void main(String[] args) {
		SpringApplication.run(TestSale.class, args);
	}
}