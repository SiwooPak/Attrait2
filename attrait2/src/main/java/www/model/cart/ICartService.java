package www.model.cart;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ICartService implements CartService {
	@Autowired
	private CartDAO dao;
	
	@Override
	public void createCart(Map<String, String> cartParam) {
		dao.createCart(cartParam);
	}

	@Override
	public List<Map<String, String>> retrieveCartList(Map<String, String> cartParam) {
		return dao.retrieveCartList(cartParam);
	}

	@Override
	public void deleteCart(Map<String, String> cartParam) {
		dao.deleteCart(cartParam);
	}

}
