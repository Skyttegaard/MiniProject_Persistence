package DB;
import Model.Customer;
public interface CustomerDBIF {
	public Customer findCustomer(String email);

}
