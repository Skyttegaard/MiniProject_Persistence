package DB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.Customer;
public class CustomerDB implements CustomerDBIF{
	
	private static final String findCustomerStmt = "TODO";
	private PreparedStatement findCustomer; //TODO
	
	
	private Customer BuildProject(ResultSet rs) {
		//TODO
		return null;
	}
	
	public Customer findCustomer(String email) {
		//TODO
		return null;
	}
	
	public Customer addCustomer(Customer customer) {
		//TODO
		return null;
	}
	
}
