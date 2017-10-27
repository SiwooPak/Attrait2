package www.model.mark;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MarkDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	public void setMybatis(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}
	
	public Map<String, String> retrieveMark(Map<String, String> markParam){
		return mybatis.selectOne("mark.retrieveMark", markParam);
	}

	public void createMark(Map<String, String> markParam){
		mybatis.insert("mark.createMark", markParam);
	}
}
