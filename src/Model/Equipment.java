package Model;

public class Equipment extends Product {

	public Equipment(int productId, String name, int purchasePrice, int salesPrice, int rentPrice,
			String countryOfOrigin, int minStock, String productType, String type, String description) {
		super(productId, name, purchasePrice, salesPrice, rentPrice, countryOfOrigin, minStock, productType);
		this.type = type;
		this.description = description;
	}
	private String type;
	private String description;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
