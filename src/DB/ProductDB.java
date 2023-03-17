package DB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Clothing;
import Model.Equipment;
import Model.GunReplica;
import Model.Product;

public class ProductDB implements ProductDBIF {
	private static final String findProductTypeStmt = "SELECT productType,productId FROM PRODUCT WHERE name = ?";
	private static final String findProductStmt = "SELECT * from product INNER JOIN %s ON Product.productId = %s.productId WHERE Product.productId = ?"; 
	private PreparedStatement findProduct;
	private PreparedStatement findProductType;
	
	private Product BuildObject(ResultSet rs) {
		int productId = 0;
		String name = null;
		int purchasePrice = 0; 
		int salesPrice = 0;
		int rentPrice = 0;
		String countryOfOrigin = null;
		int minStock = 0;
		int supplierId = 0;
		String productType = null;
		try {
			if(rs.next()) {
				productId = rs.getInt(1);
				name = rs.getString(2);
				purchasePrice = rs.getInt(3);
				salesPrice = rs.getInt(4);
				rentPrice = rs.getInt(5);
				countryOfOrigin = rs.getString(6);
				minStock = rs.getInt(7);
				supplierId = rs.getInt(8);
				productType = rs.getString(9);
			}
			
		} catch(SQLException e) {
			System.out.println(e);
		}
		
		Product product = null;
		try {
			switch(productType) {
			case "Clothing":
				String size = rs.getString(11);
				String colour = rs.getString(12);
				product = new Clothing(productId,name,purchasePrice,salesPrice,rentPrice,countryOfOrigin,minStock,productType,size,colour);
				break;
			case "GunReplica":
				String calibre = rs.getString(11);
				String material = rs.getString(12);
				product = new GunReplica(productId,name,purchasePrice,salesPrice,rentPrice,countryOfOrigin,minStock,productType,calibre,material);
				break;
			case "Equipment":
				String type = rs.getString(11);
				String description = rs.getString(12);
				product = new Equipment(productId,name,purchasePrice,salesPrice,rentPrice,countryOfOrigin,minStock,productType,type, description);
				break;
			default:
				product = null;
				
			}
			
		} catch(SQLException e) {
			System.out.println(e);
		}
		return product;
	}
	public Product findProduct(String name) {
		ResultSet rs = null;
		String productType = null;
		int productId = 0;
		try {
			findProductType = DBConnection.getInstance().getDBCon().prepareStatement(findProductTypeStmt);
			findProductType.setString(1, name);
			ResultSet resultSet = findProductType.executeQuery();
			if(resultSet.next()) {
				productType = resultSet.getString(1);				
				productId = resultSet.getInt(2);
			}
			
			String s = String.format(findProductStmt, productType, productType);
			findProduct = DBConnection.getInstance().getDBCon().prepareStatement(s);
			
			findProduct.setInt(1, productId);
			rs = findProduct.executeQuery();
			
		} catch(SQLException e) {
			System.out.println(e);
		}
		return BuildObject(rs);
	}
	
}
