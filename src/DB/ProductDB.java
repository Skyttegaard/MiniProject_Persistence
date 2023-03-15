package DB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.Product;

public class ProductDB implements ProductDBIF {
	private static final String findProductStmt = "TODO";
	private PreparedStatement findProduct; //TODO
	
	private Product BuildObject(ResultSet rs) {
		//TODO
		return null;
	}
	public Product findProduct(String name) {
		//TODO
		return null;
	}
	
}
