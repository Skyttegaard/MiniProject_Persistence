package Model;

public class GunReplica extends Product{
	private String calibre;
	private String material;

	public GunReplica(int productId, String name, int purchasePrice, int salesPrice, int rentPrice,
			String countryOfOrigin, int minStock, String productType, String calibre, String material) {
		super(productId, name, purchasePrice, salesPrice, rentPrice, countryOfOrigin, minStock, productType);
		this.calibre = calibre;
		this.material = material;
	}
	
	public String getCalibre() {
		return calibre;
	}
	public void setCalibre(String calibre) {
		this.calibre = calibre;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}

}
