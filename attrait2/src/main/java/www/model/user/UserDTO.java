package www.model.user;

public class UserDTO {
	private String userCode; // 유저코드
	private String id; // 아이디
	private String pw; // 패스워드
	private String email; // 이메일
	private String userImage; // 유저이미지
	private String name; // 이름
	private String birth; // 생년월일
	private String postNum; // 우편번호
	private String phoneCd; // 전화번호앞자리코드
	private String phoneNum; // 전화번호뒷자리
	private String address1; // 주소
	private String address2; // 주소
	private String entDate; // 회원가입일
	private String grade; // 회원등급
	
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(String userCode, String id, String pw, String email, String userImage, String name, String birth,
			String postNum, String phoneCd, String phoneNum, String address1, String address2, String entDate,
			String grade) {
		super();
		this.userCode = userCode;
		this.id = id;
		this.pw = pw;
		this.email = email;
		this.userImage = userImage;
		this.name = name;
		this.birth = birth;
		this.postNum = postNum;
		this.phoneCd = phoneCd;
		this.phoneNum = phoneNum;
		this.address1 = address1;
		this.address2 = address2;
		this.entDate = entDate;
		this.grade = grade;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPostNum() {
		return postNum;
	}

	public void setPostNum(String postNum) {
		this.postNum = postNum;
	}

	public String getPhoneCd() {
		return phoneCd;
	}

	public void setPhoneCd(String phoneCd) {
		this.phoneCd = phoneCd;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getEntDate() {
		return entDate;
	}

	public void setEntDate(String entDate) {
		this.entDate = entDate;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "UserDTO [userCode=" + userCode + ", id=" + id + ", pw=" + pw + ", email=" + email + ", userImage="
				+ userImage + ", name=" + name + ", birth=" + birth + ", postNum=" + postNum + ", phoneCd=" + phoneCd
				+ ", phoneNum=" + phoneNum + ", address1=" + address1 + ", address2=" + address2 + ", entDate="
				+ entDate + ", grade=" + grade + "]";
	}
	
}
