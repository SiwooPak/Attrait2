package www.model.cart;

import java.util.*;

public interface CartService {
	public void createCart(Map<String, String> cartParam);
	public List<Map<String, String>> retrieveCartList(Map<String, String> cartParam);
	public void deleteCart(Map<String, String> cartParam);
}
