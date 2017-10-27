package www.model.product;

public class ProductDTO {
	private String productCode;        //��ǰ�ڵ�
	private String productImage;       //��ǰ�̹���
	private String productName;        //��ǰ�̸�
 	private int productUnitPrice;      //��ǰ�ܰ�
	private int productCount;          //��ǰ����
	private String productCategoryCd;  //��ǰ�з�
	private String productRegDate;     //��ǰ�����
	
	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDTO(String productCode, String productImage, String productName, int productUnitPrice,
			int productCount, String productCategoryCd, String productRegDate) {
		super();
		this.productCode = productCode;
		this.productImage = productImage;
		this.productName = productName;
		this.productUnitPrice = productUnitPrice;
		this.productCount = productCount;
		this.productCategoryCd = productCategoryCd;
		this.productRegDate = productRegDate;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductUnitPrice() {
		return productUnitPrice;
	}

	public void setProductUnitPrice(int productUnitPrice) {
		this.productUnitPrice = productUnitPrice;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public String getProductCategoryCd() {
		return productCategoryCd;
	}

	public void setProductCategoryCd(String productCategoryCd) {
		this.productCategoryCd = productCategoryCd;
	}

	public String getProductRegDate() {
		return productRegDate;
	}

	public void setProductRegDate(String productRegDate) {
		this.productRegDate = productRegDate;
	}

	@Override
	public String toString() {
		return "ProductDTO [productCode=" + productCode + ", productImage=" + productImage + ", productName="
				+ productName + ", productUnitPrice=" + productUnitPrice + ", productCount=" + productCount
				+ ", productCategoryCd=" + productCategoryCd + ", productRegDate=" + productRegDate + "]";
	}
	
}
