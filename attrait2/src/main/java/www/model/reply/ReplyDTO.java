package www.model.reply;

public class ReplyDTO {
	private String productCode; // 제품코드
	private String userCode; // 유저코드
	private int userReplyNo; // 댓글일련번호
	private String userReply; // 댓글내용
	private String replyDate; // 댓글날짜
	
	public ReplyDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReplyDTO(String productCode, String userCode, int userReplyNo, String userReply, String replyDate) {
		super();
		this.productCode = productCode;
		this.userCode = userCode;
		this.userReplyNo = userReplyNo;
		this.userReply = userReply;
		this.replyDate = replyDate;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public int getUserReplyNo() {
		return userReplyNo;
	}

	public void setUserReplyNo(int userReplyNo) {
		this.userReplyNo = userReplyNo;
	}

	public String getUserReply() {
		return userReply;
	}

	public void setUserReply(String userReply) {
		this.userReply = userReply;
	}

	public String getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}

	@Override
	public String toString() {
		return "ReplyDTO [productCode=" + productCode + ", userCode=" + userCode + ", userReplyNo=" + userReplyNo
				+ ", userReply=" + userReply + ", replyDate=" + replyDate + "]";
	}
	
}
