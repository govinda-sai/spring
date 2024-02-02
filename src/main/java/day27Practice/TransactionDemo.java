package day27Practice;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Component
public class TransactionDemo {
	@Autowired
	SaleRepo sr;
	@Autowired
	ProductRepo pr;

	public void insertSale() {
		Sale sale = new Sale();
		sale.setProdid(103);
		sale.setTransdate(LocalDate.now());
		sale.setQty(40);
		sale.setAmount(42000);
		sr.save(sale);
	}

	// Exception
	@Transactional (propagation = Propagation.REQUIRES_NEW) 
	public void deleteSale1 (int invno, int qty) throws IllegalAccessException {
		var optionalInvno = sr.findById(invno); 
		try {
				if (!optionalInvno.isPresent()) {
				System.out.println("Invoice number not found");
				throw new IllegalArgumentException("Invoice number not found");
			} else {
				var sale = optionalInvno.get();
				if (qty < sale.getQty()) {
					sale.setQty(sale.getQty() - qty);
					sr.save(sale);
					
					// product id in sales
					var saleProdid = sale.getProdid();
					var optionalProdid = pr.findById(saleProdid);
					// product id in products
					Product product = optionalProdid.get();
					
					product.setQoh(product.getQoh() + qty);
					pr.save(product);
				} else {
					throw new IllegalArgumentException("Invalid quantity");
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	// setRollBackOnly()
	@Transactional (propagation = Propagation.REQUIRES_NEW) 
	public void deleteSale2 (int invno, int qty) throws Exception {
		TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
		var optionalInvno = sr.findById(invno); 
		try {
				if (!optionalInvno.isPresent()) {
				System.out.println("Invoice number not found");
				System.out.println("Transaction rolled back");
				status.setRollbackOnly();
				return;
			} else {
				var sale = optionalInvno.get();
				if (qty < sale.getQty()) {
					sale.setQty(sale.getQty() - qty);
					sr.save(sale);
					
					// product id in sales
					var saleProdid = sale.getProdid();
					var prodid = pr.findById(saleProdid);
					// product id in products
					Product product = prodid.get();
					
					product.setQoh(product.getQoh() + qty);
					pr.save(product);
				} else {
					status.setRollbackOnly();
					System.out.println("Transaction rolled back");
					return;
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
}