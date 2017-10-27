package www.model.product;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IProductService implements ProductService {
	@Autowired
	private ProductDAO dao;
	
	@Override
	public List<Map<String, String>> retrieveProductList(Map<String, String> productParam) {
		return dao.retrieveProductList(productParam);
	}

	@Override
	public List<Map<String, String>> retrieveProductListForMain() {
		return dao.retrieveProductListForMain();
	}

	@Override
	public List<Map<String, String>> retrieveProductListForBinder() {
		return dao.retrieveProductListForBinder();
	}

	@Override
	public List<Map<String, String>> retrieveProductListForDesign() {
		return dao.retrieveProductListForDesign();
	}

	@Override
	public List<Map<String, String>> retrieveProductListForOffice() {
		return dao.retrieveProductListForOffice();
	}

	@Override
	public List<Map<String, String>> retrieveProductListForPen() {
		return dao.retrieveProductListForPen();
	}

	@Override
	public List<Map<String, String>> retrieveProductListForStorage() {
		return dao.retrieveProductListForStorage();
	}

	@Override
	public Map<String, String> retrieveProduct(Map<String, String> productParam) {
		return dao.retrieveProduct(productParam);
	}

	@Override
	public void createProduct(ProductDTO product) {
		dao.createProduct(product);
	}

	@Override
	public void updateProduct(ProductDTO product) {
		dao.updateProduct(product);
	}

	@Override
	public void updateProductCountMinus(Map<String, String> productParam) {
		dao.updateProductCountMinus(productParam);
	}

	@Override
	public void updateProductCountPlus(Map<String, String> productParam) {
		dao.updateProductCountPlus(productParam);
	}

	@Override
	public String retrieveMaxProductCode() {
		return dao.retrieveMaxProductCode();
	}

	@Override
	public List<Map<String, String>> retrieveStatisticsForStock(Map<String, String> productParam) {
		return dao.retrieveStatisticsForStock(productParam);
	}

	@Override
	public List<Map<String, String>> retrieveStatisticsForSell() {
		return dao.retrieveStatisticsForSell();
	}

}
