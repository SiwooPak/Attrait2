package www.model.user;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	public void setMybatis(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}
	
	public List<UserDTO> retrieveUserList()  {
		return mybatis.selectList("user.retrieveUserList");
	}

	public String retrieveUserId(String email){
		return mybatis.selectOne("user.retrieveUserId", email);
	}

	public UserDTO retrieveSessionInfo(String id){
		return mybatis.selectOne("user.retrieveSessionInfo", id);
	}

	public String retrieveUserPw(String id, String email){
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("id", id);
		hm.put("email", email);
		return mybatis.selectOne("user.retrieveUserPw", hm);
	}

	public UserDTO retrieveUser(String id)  {
		return mybatis.selectOne("user.retrieveUser", id);
	}

	public boolean logincheck(String id, String pw){
		boolean check = false;
		String email = null;
		HashMap<String, String> hm = new HashMap<String, String>();

		hm.put("id", id);
		hm.put("pw", pw);

		email = mybatis.selectOne("user.logincheck", hm);
		if(email != null){
			check = true;
		}
		return check;
	}

	public void deleteUser(String id)  {
		mybatis.delete("user.deleteUser",id);
	}

	public void createUser(UserDTO bean)  {
		mybatis.insert("user.createUser", bean);
	}

	public void updateUser(UserDTO bean)  {
		mybatis.update("user.updateUser", bean);
	}

	public List<Map<String, String>> retrievePostByDong(Map<String, String> userParam){
		return mybatis.selectList("user.retrievePostByDong", userParam);
	}

	public void updatePlusRentBookCnt(Map<String, String> userParam){
		mybatis.update("user.updatePlusRentBookCnt", userParam);
	}

	public void updateMinusRentBookCnt(Map<String, String> userParam){
		mybatis.update("user.updateMinusRentBookCnt", userParam);
	}

	public void updatePlusReserveBookCnt(Map<String, String> userParam){
		mybatis.update("user.updatePlusReserveBookCnt", userParam);
	}

	public void updateMinusReserveBookCnt(Map<String, String> userParam){
		mybatis.update("user.updateMinusReserveBookCnt", userParam);
	}


	public Map<String,String> retrieveRentBookCnt(Map<String, String> userParam){
		return mybatis.selectOne("user.retrieveRentBookCnt", userParam);
	}

	public Map<String,String> retrieveReserveBookCnt(Map<String, String> userParam){
		return mybatis.selectOne("user.retrieveReserveBookCnt", userParam);
	}
}
