package www.model.product;

import java.util.*;

public interface ProductService {
	public List<Map<String, String>> retrieveProductList(Map<String, String> productParam);
	public List<Map<String, String>> retrieveProductListForMain();

	public List<Map<String, String>> retrieveProductListForBinder();
	public List<Map<String, String>> retrieveProductListForDesign();
	public List<Map<String, String>> retrieveProductListForOffice();
	public List<Map<String, String>> retrieveProductListForPen();
	public List<Map<String, String>> retrieveProductListForStorage();

	public Map<String, String> retrieveProduct(Map<String, String> productParam);

	public void createProduct(ProductDTO product);
	public void updateProduct(ProductDTO product);

	public void updateProductCountMinus(Map<String, String> productParam);
	public void updateProductCountPlus(Map<String, String> productParam);

	public String retrieveMaxProductCode();

	public List<Map<String, String>> retrieveStatisticsForStock(Map<String, String> productParam);

	public List<Map<String, String>> retrieveStatisticsForSell();
}
