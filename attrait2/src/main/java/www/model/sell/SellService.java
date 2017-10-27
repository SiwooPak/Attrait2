package www.model.sell;

import java.util.*;

public interface SellService {
	public void createSell(Map<String, String> sellParam);
	public List<Map<String, String>> retrieveSellList(Map<String, String> sellParam);

	public List<Map<String, String>> retrieveBuyList(Map<String, String> sellParam);

	public String retrieveMaxSellCode();

	public void updateSellYn(Map<String, String> sellParam);

	public List<Map<String, String>> retrieveStatisticsForProduct();
	public List<Map<String, String>> retrieveStatisticsForCategory();
}
