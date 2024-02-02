package day24Practice.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

//@Component
public class Delete {
	@Autowired
	NamedParameterJdbcTemplate npJdbc;

	public void deleteNp(String code) {
		var params = new MapSqlParameterSource()
					.addValue("code", code);

		npJdbc.update("delete from categories where catcode = (:code)", params);
	}
	/*
	 * JdbcTemplate jdbc; public void delete (String code) { Integer count =
	 * jdbc.update("delete from categories where catcode = ?", code); if(count ==
	 * null) { System.out.println("(0) rows affected"); }
	 * System.out.println("Number of rows affected: " + count); }
	 */
}