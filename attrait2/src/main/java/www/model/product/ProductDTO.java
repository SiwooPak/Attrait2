package www.model.product;

public class ProductDTO {
	private String productCode;        //力前内滴
	private String productImage;       //力前捞固瘤
	private String productName;        //力前捞抚
 	private int productUnitPrice;      //力前窜啊
	private int productCount;          //力前荐樊
	private String productCategoryCd;  //力前盒幅
	private String productRegDate;     //力前殿废老
	
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
