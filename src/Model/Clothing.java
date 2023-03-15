package Model;

public class Clothing extends Product {
	public Clothing(int productId, String name, int purchasePrice, int salesPrice, int rentPrice,
			String countryOfOrigin, int minStock, String productType, String size, String colour) {
		super(productId, name, purchasePrice, salesPrice, rentPrice, countryOfOrigin, minStock, productType);
		this.size = size;
		this.colour = colour;
	}
	private String size;
	private String colour;
	
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	

}
