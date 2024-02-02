package day24Practice.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Component
public class SwapDescription {
	@Autowired 
	JdbcTemplate jdbc;
	
	@Transactional (propagation = Propagation.REQUIRED)
	public void swap(String code1, String code2) {
		TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
		
		String desc1 = jdbc.queryForObject
				("select catdesc from categories where catcode = ?", String.class, code1);
		String desc2 = jdbc.queryForObject 
				("select catdesc from categories where catcode = ?", String.class, code2);
		
		int count = jdbc.update("update categories set catdesc = ? where catcode = ?", desc2, code1);
		
		if(count == 0) {
			status.setRollbackOnly();
			return;
		} else {
			System.out.println("First update done");
			
			count = jdbc.update("update categories set catdesc = ? where catcode = ?", desc1, code2);
			if(count == 0) {
				status.setRollbackOnly();
				return;
			} else {
				System.out.println(count + " row(s) updated");
			}
			
			System.out.println("Second update done");
		}
	}
}