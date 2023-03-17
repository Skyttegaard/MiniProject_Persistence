package Controller;

import java.time.LocalDate;
import java.util.Date;

import DB.SalesOrderDB;
import DB.SalesOrderDBIF;
import Model.OrderLine;
import Model.Product;
import Model.SalesOrder;

public class SalesOrderController implements SalesOrderControllerIF {
	private static SalesOrder newOrder;
	private CustomerController customerController = new CustomerController();
	private SalesOrderDBIF salesOrderDB = new SalesOrderDB();
	private ProductController productController = new ProductController();
	public void createOrder() {
		newOrder = new SalesOrder();
		
	}
	
	public void findAndAddCustomer(String email) {
		newOrder.setCustomerId(customerController.findCustomer(email).getCustomerId());
	}
	
	public void findAndAddProduct(String name, int amount, int price) {
		
		Product product = productController.findProduct(name);
		OrderLine orderLine = new OrderLine(amount,price,product);
		newOrder.addOrderLine(orderLine);
		
		
	}
	
	public void setTotalPrice(int totalPrice) {
		newOrder.setTotalPrice(totalPrice);
	}
	
	public void setDates(Date delivery, Date payment) {
		newOrder.setDeliveryStatus("Pending");
		newOrder.setDate(new Date());
		newOrder.setDeliveryDate(delivery);
		newOrder.setPaymentDate(payment);
	}
	public void completeOrder() {
		salesOrderDB.addOrder(newOrder);
		
	}
}
