package www.model.code;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CodeDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	public void setMybatis(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}
	
	public List<CodeDTO> retrieveCodeList(Map<String, String> codeParam)  {
		System.out.println("codeParam: "+codeParam.get("commTyCd"));
		return mybatis.selectList("code.retrieveCodeList", codeParam);
	}

}
