package www.model.user;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IUserService implements UserService {
	@Autowired
	private UserDAO dao;
	
	public String retrieveUserId(String email){
		return dao.retrieveUserId(email);
	}

	public String retrieveUserPw(String id, String email){
		return dao.retrieveUserPw(id, email);
	}

	public List<UserDTO> retrieveUserList()  {
		return dao.retrieveUserList();
	}

	public UserDTO retrieveUser(String id)  {
		System.out.println(id);
		return dao.retrieveUser(id);
	}

	public UserDTO retrieveSessionInfo(String id)  {
		return dao.retrieveSessionInfo(id);
	}

	public boolean logincheck(String id, String pw){
		return dao.logincheck(id, pw);
	}

	public void deleteUser(String id)  {
		dao.deleteUser(id);
	}

	public void createUser(UserDTO bean)  {
		dao.createUser(bean);
	}

	public void updateUser(UserDTO bean)  {
		dao.updateUser(bean);
	}

	public List<Map<String, String>> retrievePostByDong(Map<String, String> userParam){
		return dao.retrievePostByDong(userParam);
	}

	public void updatePlusRentBookCnt(Map<String, String> userParam){
		dao.updatePlusRentBookCnt(userParam);
	}

	public void updateMinusRentBookCnt(Map<String, String> userParam){
		dao.updateMinusRentBookCnt(userParam);
	}

	public void updatePlusReserveBookCnt(Map<String, String> userParam){
		dao.updatePlusReserveBookCnt(userParam);
	}

	public void updateMinusReserveBookCnt(Map<String, String> userParam){
		dao.updateMinusReserveBookCnt(userParam);
	}

	public Map<String,String> retrieveRentBookCnt(Map<String, String> userParam){
		return dao.retrieveRentBookCnt(userParam);
	}

	public Map<String,String> retrieveReserveBookCnt(Map<String, String> userParam){
		return dao.retrieveReserveBookCnt(userParam);
	}

}
