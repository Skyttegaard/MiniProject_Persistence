package DB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Customer;
public class CustomerDB implements CustomerDBIF{
	
	private static final String findCustomerStmt = "SELECT * FROM CUSTOMER WHERE email = ?";
	private static final String addCustomerStmt = "INSERT INTO CUSTOMER(name,email,address,zipcode,city,phone)"
			+ " values (?,?,?,?,?,?)";
	private PreparedStatement findCustomer;
	private PreparedStatement addCustomer;
	
	private Customer BuildProject(ResultSet rs) {
		Customer customer;
		int customerId;
		String name;
		String email;
		String address;
		String zipcode;
		String city;
		String phone;
		try {
			if(rs.next()) {
				customerId = rs.getInt(1);
				name = rs.getString(2);
				email = rs.getString(3);
				address = rs.getString(4);
				zipcode = rs.getString(5);
				city = rs.getString(6);
				phone = rs.getString(7);
				customer = new Customer(customerId,name,email,address,zipcode,city,phone);
			}
			else {
				customer = null;
			}
			
		} catch(SQLException e) {
			customer = null;
		}
		
		return customer;
		
	}
	
	public Customer findCustomer(String email) {
		ResultSet rs = null;
		try {
			findCustomer = DBConnection.getInstance().getDBCon().prepareStatement(findCustomerStmt);
			findCustomer.setString(1, email);
			rs = findCustomer.executeQuery();
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return BuildProject(rs);
	}
	
	public Customer addCustomer(Customer customer) {
		DBConnection.getInstance().startTransaction();
		try {
			addCustomer = DBConnection.getInstance().getDBCon().prepareStatement(addCustomerStmt, Statement.RETURN_GENERATED_KEYS);
			addCustomer.setString(1, customer.getName());
			addCustomer.setString(2, customer.getEmail());
			addCustomer.setString(3, customer.getAddress());
			addCustomer.setString(4, customer.getZipcode());
			addCustomer.setString(5, customer.getCity());
			addCustomer.setString(6, customer.getPhone());
			addCustomer.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e);
			DBConnection.getInstance().rollbackTransaction();
		} finally {
			DBConnection.getInstance().commitTransaction();
		}
		
		return findCustomer(customer.getEmail());
	}
	
}
