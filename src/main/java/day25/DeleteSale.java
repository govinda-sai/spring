package day25;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Component
public class DeleteSale {
	@Autowired 
	JdbcTemplate jdbc;
	
	@Transactional (propagation = Propagation.REQUIRED)
	public void deleteSale(Integer invno, Integer quantity) {
		TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
		try {
			Integer count = jdbc.update
					("update sales set qty = (qty - ?) where invno = ?", quantity, invno);
			if(count == 0) {
				System.out.println("sales table not updated");
				status.setRollbackOnly();
				return;
			} else {
				System.out.println("sales table updated");
				Integer prodid = jdbc.queryForObject
						("select prodid from sales where invno = ?", Integer.class, invno);
				if(prodid != null) {
					count = jdbc.update("update products set qoh = (qoh + ?) where prodid = ?", quantity, prodid);
					if(count == 0) {
						System.out.println("products table not updated");
						status.setRollbackOnly();
						return;
					} else {
						System.out.println("products table updated");
					}
				} else {
					status.setRollbackOnly();
					return;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}	