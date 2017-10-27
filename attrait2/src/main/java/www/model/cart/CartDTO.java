package www.model.cart;

public class CartDTO {
	private String cartCode;    //��ٱ����ڵ�
	private String productCode; //��ǰ�ڵ�
	private String userCode;    //�����ڵ�
	private int cartPrice;      //�ǸŴܰ�
	private int cartCount;      //�Ǹż���
	private String cartDate;    //��ٱ��Ͽ� ������¥
	
	public CartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartDTO(String cartCode, String productCode, String userCode, int cartPrice, int cartCount,
			String cartDate) {
		super();
		this.cartCode = cartCode;
		this.productCode = productCode;
		this.userCode = userCode;
		this.cartPrice = cartPrice;
		this.cartCount = cartCount;
		this.cartDate = cartDate;
	}

	public String getCartCode() {
		return cartCode;
	}

	public void setCartCode(String cartCode) {
		this.cartCode = cartCode;
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

	public int getCartPrice() {
		return cartPrice;
	}

	public void setCartPrice(int cartPrice) {
		this.cartPrice = cartPrice;
	}

	public int getCartCount() {
		return cartCount;
	}

	public void setCartCount(int cartCount) {
		this.cartCount = cartCount;
	}

	public String getCartDate() {
		return cartDate;
	}

	public void setCartDate(String cartDate) {
		this.cartDate = cartDate;
	}

	@Override
	public String toString() {
		return "CartDTO [cartCode=" + cartCode + ", productCode=" + productCode + ", userCode=" + userCode
				+ ", cartPrice=" + cartPrice + ", cartCount=" + cartCount + ", cartDate=" + cartDate + "]";
	}
	
}
