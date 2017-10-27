package www.model.product;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	public void setMybatis(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}

	public List<Map<String, String>> retrieveProductList(Map<String, String> productParam){
		return mybatis.selectList("product.retrieveProductList", productParam);
	}

	public List<Map<String, String>> retrieveProductListForMain(){
		return mybatis.selectList("product.retrieveProductListForMain");
	}

	public List<Map<String, String>> retrieveProductListForBinder(){
		return mybatis.selectList("product.retrieveProductListForBinder");
	}

	public List<Map<String, String>> retrieveProductListForDesign(){
		return mybatis.selectList("product.retrieveProductListForDesign");
	}

	public List<Map<String, String>> retrieveProductListForOffice(){
		return mybatis.selectList("product.retrieveProductListForOffice");
	}

	public List<Map<String, String>> retrieveProductListForPen(){
		return mybatis.selectList("product.retrieveProductListForPen");
	}

	public List<Map<String, String>> retrieveProductListForStorage(){
		return mybatis.selectList("product.retrieveProductListForStorage");
	}

	public Map<String, String> retrieveProduct(Map<String, String> productParam){
		return mybatis.selectOne("product.retrieveProduct", productParam);
	}

	public void createProduct(ProductDTO product){
		mybatis.insert("product.createProduct", product);
	}

	public String retrieveMaxProductCode(){
		return mybatis.selectOne("product.retrieveMaxProductCode");
	}

	public void updateProduct(ProductDTO product){
		mybatis.update("product.updateProduct", product);
	}

	public void updateProductCountMinus(Map<String, String> productParam){
		mybatis.update("product.updateProductCountMinus", productParam);
	}

	public void updateProductCountPlus(Map<String, String> productParam){
		mybatis.update("product.updateProductCountPlus", productParam);
	}

	public List<Map<String, String>> retrieveStatisticsForStock(Map<String, String> productParam){
		return mybatis.selectList("product.retrieveStatisticsForStock", productParam);
	}

	public List<Map<String, String>> retrieveStatisticsForSell(){
		return mybatis.selectList("product.retrieveStatisticsForSell");
	}

}
