package day24Practice.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class NamedParameter {
	@Autowired 
	NamedParameterJdbcTemplate npJdbc;
	public void addCategory(String code, String description) {
		var params = new MapSqlParameterSource()
					.addValue("code", code)
					.addValue("desc", description);
		int count = npJdbc.update("insert into categories values (:code, :desc)", params);
		System.out.println(count + " row(s) affected");
	}
}