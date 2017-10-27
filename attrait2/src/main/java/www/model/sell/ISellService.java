package www.model.sell;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ISellService implements SellService {
	@Autowired
	private SellDAO dao;
	
	@Override
	public void createSell(Map<String, String> sellParam) {
		dao.createSell(sellParam);
	}

	@Override
	public List<Map<String, String>> retrieveSellList(Map<String, String> sellParam) {
		return dao.retrieveSellList(sellParam);
	}

	@Override
	public List<Map<String, String>> retrieveBuyList(Map<String, String> sellParam) {
		return dao.retrieveBuyList(sellParam);
	}

	@Override
	public String retrieveMaxSellCode() {
		return dao.retrieveMaxSellCode();
	}

	@Override
	public void updateSellYn(Map<String, String> sellParam) {
		dao.updateSellYn(sellParam);
	}

	@Override
	public List<Map<String, String>> retrieveStatisticsForProduct() {
		return dao.retrieveStatisticsForProduct();
	}

	@Override
	public List<Map<String, String>> retrieveStatisticsForCategory() {
		return dao.retrieveStatisticsForCategory();
	}

}
