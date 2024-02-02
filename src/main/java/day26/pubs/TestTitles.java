package day26.pubs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

@SpringBootApplication
public class TestTitles implements CommandLineRunner {
	@Autowired 
	TitleRepo tr;
	
	@Autowired 
	PublisherRepo pr;
	
	public void run(String...strings) {
		// 10
		for (var v : tr.findAll(Sort.by("price").descending())) {
			System.out.println(v);
		}
		
		// 11
		for (var v : tr.topTitlesByYtdSales()) {
			System.out.println(v);
		}
		
		// 12
		for (var v : tr.sortByPublisherCity()) {
			System.out.println(v);
		}
		
		// 13 
		for (var v : tr.pubNameAvgPriceList()) {
			System.out.printf("%-30s %-9.2f\n", v.getPubName(), v.getPrice());
		} 
		
//		for (var v : pr.findAll()) {
//			for (var w : v.getTitlesList()) {
//				System.out.printf("%-40s %-70s\n", v.getPubName(), w.getName());
//			}
//		}
	}
	public static void main(String[] args) {
		SpringApplication.run(TestTitles.class, args);
	}
}	