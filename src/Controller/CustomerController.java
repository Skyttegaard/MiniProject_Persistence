package Controller;

import DB.CustomerDB;
import DB.CustomerDBIF;
import Model.Customer;

public class CustomerController implements CustomerControllerIF {

	private CustomerDBIF customerDB = new CustomerDB();
	public Customer findCustomer(String email) {
		return customerDB.findCustomer(email);
	}
	public Customer addCustomer(Customer customer) {
		return customerDB.addCustomer(customer);
		
	}

}
