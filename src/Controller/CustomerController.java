package Controller;

import DB.CustomerDBIF;
import Model.Customer;

public class CustomerController implements CustomerControllerIF {

	private CustomerDBIF customerDB;
	public Customer findCustomer(String email) {
		return customerDB.findCustomer(email);
	}
	public Customer addCustomer(Customer customer) {
		return customerDB.addCustomer(customer);
		
	}

}
