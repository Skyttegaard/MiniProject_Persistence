package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SalesOrder {
	private int orderNo;
	private Date date;
	private String deliveryStatus;
	private Date deliveryDate;
	private int totalPrice;
	private Date paymentDate;
	private int customerId;
	
	private List<OrderLine> orderLines;
	
	public SalesOrder() {
		orderLines = new ArrayList();
	}
	public SalesOrder(Date date, String deliveryStatus, Date deliveryDate, int totalPrice,
			Date paymentDate) {
		super();
		this.date = date;
		this.deliveryStatus = deliveryStatus;
		this.deliveryDate = deliveryDate;
		this.totalPrice = totalPrice;
		this.paymentDate = paymentDate;
		orderLines = new ArrayList();
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	public void addOrderLine(OrderLine orderLine) {
		orderLines.add(orderLine);
	}
	
	public List<OrderLine> getOrderLines(){
		
		return new ArrayList<>(orderLines);
	}

	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
}
