package practiceAOP;

import org.springframework.stereotype.Component;

@Component
public class Order {
	public void placeOrder() {
		System.out.println("placing order(s)");
	}
	
	public String getOrderStatus(int orderId) {
		if (orderId > 100) {
			System.out.println("Getting order status  for " + orderId);
			return String.valueOf(orderId);
		} else
			throw new RuntimeException("Error in getting status");
	}
	
	public void cancelOrder() {
		System.out.println("canceling order(s)");
	}
}