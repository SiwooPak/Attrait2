package www.model.user;

import java.util.*;

public interface UserService {
	public List<UserDTO> retrieveUserList();
	public UserDTO retrieveUser(String id);
	public String retrieveUserId(String email);
	public String retrieveUserPw(String id, String email);
	public boolean logincheck(String id, String pw);
	public void deleteUser(String id);
	public UserDTO retrieveSessionInfo(String id);
	public void updateUser(UserDTO bean);
	public void createUser(UserDTO bean);
	public List<Map<String, String>> retrievePostByDong(Map<String, String> userParam);

	public Map<String,String> retrieveRentBookCnt(Map<String, String> userParam);
	public Map<String,String> retrieveReserveBookCnt(Map<String, String> userParam);

	public void updatePlusRentBookCnt(Map<String, String> userParam);
	public void updateMinusRentBookCnt(Map<String, String> userParam);

	public void updatePlusReserveBookCnt(Map<String, String> userParam);
	public void updateMinusReserveBookCnt(Map<String, String> userParam);

}
