package day24.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ListProducts {
	@Autowired
	JdbcTemplate jdbc;

	public void listProducts() {
		List<Product> products = jdbc.query("select p.prodname, p.price, c.catdesc "
				+ "from products p inner join categories c on p.catcode = c.catcode", 
				(rs, rowNum) -> new Product(rs.getString("prodname"), 
						rs.getDouble("price"), rs.getString("catdesc")));
		System.out.println();
		for(var v : products) {
			System.out.printf("%-30s %-12.2f %-30s\n", v.name(), v.price(), v.catdesc());
		}
		System.out.println();
		Double avgPrice = jdbc.queryForObject("select avg(price) from products", Double.class);
		System.out.println("Average Price: " + avgPrice);
		System.out.println();
	}
}