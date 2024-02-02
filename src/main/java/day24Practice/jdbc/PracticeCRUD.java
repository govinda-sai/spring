package day24Practice.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

//@Component
public class PracticeCRUD {
	@Autowired 
	JdbcTemplate jdbc;
	
	public void listCategories() {
		List<Category> cats = jdbc.query("select * from categories", 
				(rs, rowNum) -> new Category(rs.getString("catcode"), rs.getString("catdesc")));
		for (var cat : cats) {
			System.out.printf("%-10s %-30s\n",cat.catcode(), cat.description());
		}
	}
	
	public void listCategoriesMap() {
		var cats = jdbc.queryForList("select * from categories");
		
		for (var cat : cats) {
			System.out.printf("%-10s %-30s\n",cat.get("catcode"), cat.get("catdesc"));
		}
	}
	
	public void update(String code, String description) {
		Integer count = jdbc.update("update categories set catcode = ? where catdesc = ?",
				description, code);
		System.out.println("Number of rows updated: " + count);
	}
}