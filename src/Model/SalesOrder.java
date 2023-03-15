package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SalesOrder {
	private int orderNo;
	private LocalDate date;
	private String deliveryStatus;
	private LocalDate deliveryDate;
	private int totalPrice;
	private LocalDate paymentDate;
	private List<OrderLine> orderLines;
	
	public SalesOrder(int orderNo, LocalDate date, String deliveryStatus, LocalDate deliveryDate, int totalPrice,
			LocalDate paymentDate) {
		super();
		this.orderNo = orderNo;
		this.date = date;
		this.deliveryStatus = deliveryStatus;
		this.deliveryDate = deliveryDate;
		this.totalPrice = totalPrice;
		this.paymentDate = paymentDate;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	public void addOrderLine(OrderLine orderLine) {
		orderLines.add(orderLine);
	}
	
	public List<OrderLine> getOrderLines(){
		
		return new ArrayList<>(orderLines);
	}

}
