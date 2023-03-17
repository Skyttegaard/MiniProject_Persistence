package Model;

public class OrderLine {
	private int orderAmount;
	private int productPrice;
	private Product product;
	public OrderLine(int amount, int price, Product product) {
		this.orderAmount = amount;
		this.productPrice = price;
		this.product = product;
	}
	public int getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
}
