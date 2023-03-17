package DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.OrderLine;
import Model.SalesOrder;

public class SalesOrderDB implements SalesOrderDBIF{
	private static final String addOrderStmt = "INSERT INTO SalesOrder(orderDate,deliveryStatus,deliveryDate,totalPrice,paymentDate,customerId)"
			+ " VALUES (?,?,?,?,?,?)";
	private static final String addOrderLineStmt ="INSERT INTO OrderLine(OrderAmount,productPrice,productId,orderNo)"
			+ " VALUES (?,?,?,?)";
	private PreparedStatement addOrder;
	private PreparedStatement addOrderLine;
	
	public void addOrder(SalesOrder newOrder) {
		DBConnection.getInstance().startTransaction();
		
		try {
			addOrder = DBConnection.getInstance().getDBCon().prepareStatement(addOrderStmt, Statement.RETURN_GENERATED_KEYS);
			addOrder.setDate(1, new java.sql.Date(newOrder.getDate().getTime()));
			addOrder.setString(2, newOrder.getDeliveryStatus());
			addOrder.setDate(3, new java.sql.Date(newOrder.getDeliveryDate().getTime()));
			addOrder.setInt(4, newOrder.getTotalPrice());
			addOrder.setDate(5, new java.sql.Date(newOrder.getPaymentDate().getTime()));
			addOrder.setInt(6, newOrder.getCustomerId());
			addOrder.executeUpdate();
			ResultSet rs = addOrder.getGeneratedKeys();
			while(rs.next()) {
				addOrderLine = DBConnection.getInstance().getDBCon().prepareStatement(addOrderLineStmt);
				for(OrderLine ol: newOrder.getOrderLines()) {
					addOrderLine.setInt(1, ol.getOrderAmount());
					addOrderLine.setInt(2,ol.getProductPrice());
					addOrderLine.setInt(3, ol.getProduct().getProductId());
					addOrderLine.setInt(4, rs.getInt(1));
					addOrderLine.executeUpdate();
				}
			}
			
		} catch(SQLException e) {
			System.out.println(e);
			DBConnection.getInstance().rollbackTransaction();
		} finally {
			DBConnection.getInstance().commitTransaction();
		}
		
	}

}
