package www.model.sell;

public class SellDTO {
	private String sellCode; // 판매내역코드
	private String productCode; // 제품코드
	private String userCode; // 유저코드
	private int sellPrice; // 판매단가
	private int sellCount; // 판매수량
	private String sellYn; // 판매여부
	private String sellDate; // 판매일
	
	public SellDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SellDTO(String sellCode, String productCode, String userCode, int sellPrice, int sellCount, String sellYn,
			String sellDate) {
		super();
		this.sellCode = sellCode;
		this.productCode = productCode;
		this.userCode = userCode;
		this.sellPrice = sellPrice;
		this.sellCount = sellCount;
		this.sellYn = sellYn;
		this.sellDate = sellDate;
	}

	public String getSellCode() {
		return sellCode;
	}

	public void setSellCode(String sellCode) {
		this.sellCode = sellCode;
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

	public int getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}

	public int getSellCount() {
		return sellCount;
	}

	public void setSellCount(int sellCount) {
		this.sellCount = sellCount;
	}

	public String getSellYn() {
		return sellYn;
	}

	public void setSellYn(String sellYn) {
		this.sellYn = sellYn;
	}

	public String getSellDate() {
		return sellDate;
	}

	public void setSellDate(String sellDate) {
		this.sellDate = sellDate;
	}

	@Override
	public String toString() {
		return "SellDTO [sellCode=" + sellCode + ", productCode=" + productCode + ", userCode=" + userCode
				+ ", sellPrice=" + sellPrice + ", sellCount=" + sellCount + ", sellYn=" + sellYn + ", sellDate="
				+ sellDate + "]";
	}
}
