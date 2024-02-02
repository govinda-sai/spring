package day27;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Component
public class Transaction {
	@Autowired
	SaleRepo sr;
	@Autowired
	ProductRepo pr;

	// Exception
	@Transactional (propagation = Propagation.REQUIRES_NEW) 
	public void deleteSale1 (int invno) throws IllegalAccessException {
		var optionalInvno = sr.findById(invno); 
		try {
				if (!optionalInvno.isPresent()) {
				System.out.println("Invoice number not found");
				throw new IllegalArgumentException("Invoice number not found");
			} else {
				var sale = optionalInvno.get();
				// quantity in sales
				var saleQty = sale.getQty();
				// prodid in sales
				var saleProdid = sale.getProdid();
				var productProdid = pr.findById(saleProdid);
				// prodid in products
				var product = productProdid.get();
				
				product.setQoh(product.getQoh() + saleQty);
				
				sr.deleteById(invno);
				System.out.println("Sale deleted");
				System.out.println("products updated");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	// setRollBackOnly()
	@Transactional (propagation = Propagation.REQUIRES_NEW) 
	public void deleteSale2 (int invno) throws IllegalAccessException {
		TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
		var optionalInvno = sr.findById(invno); 
		try {
				if (!optionalInvno.isPresent()) {
				System.out.println("Invoice number not found");
				status.setRollbackOnly();
				return;				
			} else {
				var sale = optionalInvno.get();
				// quantity in sales
				var saleQty = sale.getQty();
				// prodid in sales
				var saleProdid = sale.getProdid();
				var productProdid = pr.findById(saleProdid);
				// prodid in products
				var product = productProdid.get();
				
				product.setQoh(product.getQoh() + saleQty);
				
				sr.deleteById(invno);
				System.out.println("Sale deleted");
				System.out.println("products updated");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
}