package www.model.sell;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SellDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	public void setMybatis(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}

	public void createSell(Map<String, String> sellParam) {
		mybatis.insert("sell.createSell", sellParam);
	}

	public List<Map<String, String>> retrieveSellList(Map<String, String> sellParam) {
		return mybatis.selectList("sell.retrieveSellList", sellParam);
	}

	public List<Map<String, String>> retrieveBuyList(Map<String, String> sellParam) {
		return mybatis.selectList("sell.retrieveBuyList", sellParam);
	}

	public String retrieveMaxSellCode() {
		return mybatis.selectOne("sell.retrieveMaxSellCode");
	}

	public void updateSellYn(Map<String, String> sellParam) {
		mybatis.update("sell.updateSellYn", sellParam);
	}

	public List<Map<String, String>> retrieveStatisticsForProduct() {
		return mybatis.selectList("sell.retrieveStatisticsForProduct");
	}

	public List<Map<String, String>> retrieveStatisticsForCategory() {
		return mybatis.selectList("sell.retrieveStatisticsForCategory");
	}
}
