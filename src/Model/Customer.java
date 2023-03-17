package Model;

public class Customer {
	private int customerId;
	private String name;
	private String email;
	private String address;
	private String zipcode;
	private String city;
	private String phone;
	
	public Customer(String name, String email, String address, String zipcode, String city,
			String phone) {
		this.name = name;
		this.email = email;
		this.address = address;
		this.zipcode = zipcode;
		this.city = city;
		this.phone = phone;
	}
	public Customer(int customerId, String name, String email, String address, String zipcode, String city,
			String phone) {
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.address = address;
		this.zipcode = zipcode;
		this.city = city;
		this.phone = phone;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
    public String toString() {
        return "Customer [Id=" + customerId + ", Name=" + name + ", Email=" + email + ", Address=" + address + ", Zipcode=" + zipcode + ", City=" + city + ", Phone=" + phone +"]";
    }
	
	
}
