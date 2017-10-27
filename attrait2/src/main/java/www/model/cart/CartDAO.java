package www.model.cart;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void setMybatis(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}

	public void createCart(Map<String, String> cart){
		mybatis.insert("cart.createCart", cart);
	}

	public List<Map<String, String>> retrieveCartList(Map<String, String> cart){
		return mybatis.selectList("cart.retrieveCartList", cart);
	}

	public void deleteCart(Map<String, String> cart){
		mybatis.delete("cart.deleteCart", cart);
	}
}
