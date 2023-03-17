package Controller;

public interface SalesOrderControllerIF {
	public void createOrder();
	public void findAndAddCustomer(String email);
	public void findAndAddProduct(String name, int amount, int price);
	public void completeOrder();
}
