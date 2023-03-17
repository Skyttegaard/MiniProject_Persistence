package Controller;

import DB.ProductDBIF;
import Model.Product;

public class ProductController implements ProductControllerIF{
	
	private ProductDBIF productDB;
	
	public Product findProduct(String name) {
		
		return productDB.findProduct(name);
	}

}
