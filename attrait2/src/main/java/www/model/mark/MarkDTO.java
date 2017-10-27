package www.model.mark;

public class MarkDTO {
	private String productCode; // 力前内靛
	private String userCode; // 蜡历内靛
	private int markRating;

	public MarkDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MarkDTO(String productCode, String userCode, int markRating) {
		super();
		this.productCode = productCode;
		this.userCode = userCode;
		this.markRating = markRating;
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

	public int getMarkRating() {
		return markRating;
	}

	public void setMarkRating(int markRating) {
		this.markRating = markRating;
	}

	@Override
	public String toString() {
		return "MarkDTO [productCode=" + productCode + ", userCode=" + userCode + ", markRating=" + markRating + "]";
	}

}
