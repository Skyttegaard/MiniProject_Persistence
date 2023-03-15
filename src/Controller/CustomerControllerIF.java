package Controller;

import Model.Customer;

public interface CustomerControllerIF {
	public Customer findCustomer(String email);
	public Customer addCustomer(Customer customer);
}
