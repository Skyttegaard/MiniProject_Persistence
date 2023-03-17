package Controller;

import DB.ProductDB;
import DB.ProductDBIF;
import Model.Product;

public class ProductController implements ProductControllerIF{
	
	private ProductDBIF productDB = new ProductDB();
	
	public Product findProduct(String name) {
		
		return productDB.findProduct(name);
	}

}
