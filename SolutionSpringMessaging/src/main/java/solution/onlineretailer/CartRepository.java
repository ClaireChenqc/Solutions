package solution.onlineretailer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CartRepository {

	// Map of item IDs and quantities.
	private Map<Integer, Integer> cart = new HashMap<>();
	
	public void add(int itemId, int quantity) {
		Integer existingQuantity = cart.get(itemId);
		if (existingQuantity != null) {
			quantity += existingQuantity;			
		}
		cart.put(itemId,  quantity);
	}
	
	public void remove(int itemId) {
		cart.remove(itemId);
	}
	
	public Map<Integer, Integer> getAll() {
		return cart;
	}
}
