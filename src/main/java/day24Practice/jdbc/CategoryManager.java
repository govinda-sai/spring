package day24Practice.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CategoryManager {
	/* CRUD */
	@Autowired
	JdbcTemplate jdbc;

	/* update */
	public void updateCatDesc(String code, String description) {
		/* PreparedStatement */
		Integer count = 
			jdbc.update("update categories set catdesc = ? where catcode = ?", description, code);
		if (count == 0) {
			System.out.println("No rows updated");
		}
		System.out.println("Number of rows updated: " + count);
	}

	/* insert */
	public void addCategory(String code, String description) {
		Integer count = jdbc.update("insert into categories values (?, ?)", code, description);
		if (count != null) {
			System.out.println("Number of rows inserted: " + count);
		}
		System.out.println("No rows inserted");
	}

	/* list */
	/* queryForList returns a map<key, value> */
	public void listCategories() {
		var cats = jdbc.queryForList("select catcode, catdesc from categories");
		
		for(var cat : cats) {
			System.out.printf("%-10s %-30s\n", cat.get("catcode"), cat.get("catdesc"));
		}
	}
	
	/* list 
	 * it returns a list */
	/* other way */
	public void listCatObjects() {
		List<Category> categories = jdbc.query("select * from categories", 
				(rs, rowNum) -> new Category(rs.getString("catcode"), rs.getString("catdesc")));
		
		for(var cat : categories) {
			System.out.printf("%-10s %-30s\n", cat.catcode(), cat.description());
		}
		/*
		 * RowMapper (mapRow(rs, int)) is implemented using lambda expression 
		 * rs is ResultSet Interface, RowMapper is a @FunctionalInterface 
		 * */
	}
	
	/* category count */ 
	/* queryForObject */
	public void showCategoryCount() {
		Integer count = jdbc.queryForObject("select count(*) from categories", Integer.class);
		System.out.println("Categories count: " + count);
		/* queryForObject is useful when we want to return a single value */
	}
}
