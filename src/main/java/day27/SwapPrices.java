package day27;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Component
public class SwapPrices {
	@Autowired 
	ProductRepo pr; 
	
	@Transactional (propagation = Propagation.REQUIRED)
	public void swapPrices(int prodid1, int prodid2) {
		var optionalProdid1 = pr.findById(prodid1);
		var optionalProdid2 = pr.findById(prodid2);
		
		TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
		
		if (optionalProdid1.isPresent() && optionalProdid2.isPresent()) {
			var product1 = optionalProdid1.get();
			var product2 = optionalProdid2.get();
			
			var price1 = product1.getPrice();
			var price2 = product2.getPrice();
			
			product1.setPrice(price2);
			pr.save(product1);
			product2.setPrice(price1);
			pr.save(product2);
			
			System.out.println("Prices swapped");
		} else {
			System.out.println("Invalid product id(s)");
			status.setRollbackOnly();
			return;
		}
	}
}