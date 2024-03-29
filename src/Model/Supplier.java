package Model;

public class Supplier {
	private int supplierId;
	private String name;
	private String address;
	private String country;
	private String phone;
	private String email;
	
	public Supplier(int supplierId, String name, String address, String country, String phone, String email) {
		super();
		this.supplierId = supplierId;
		this.name = name;
		this.address = address;
		this.country = country;
		this.phone = phone;
		this.email = email;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
