package DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Product;
import Model.Supplier;

public class SupplierDB implements SupplierDBIF {
	private static final String getSupplierInfoStmt = "SELECT * FROM Supplier WHERE supplierId = ?";
	private PreparedStatement getSupplierInfo;
	
	private Supplier BuildObject(ResultSet rs) {
		Supplier supplier = null;
		try {
			if(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String address = rs.getString(3);
				String country = rs.getString(4);
				String phone = rs.getString(5);
				String email = rs.getString(6);
				supplier = new Supplier(id,name,address,country,phone,email);
			}
			
		} catch(SQLException e) {
			System.out.println(e);
			
		}
		return supplier;
	}
	
	public Supplier getSupplierInfo(Product product) {
		ResultSet rs = null;
		try {
			getSupplierInfo = DBConnection.getInstance().getDBCon().prepareStatement(getSupplierInfoStmt);
			getSupplierInfo.setInt(1, product.getSupplier().getSupplierId());
			rs = getSupplierInfo.executeQuery();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return BuildObject(rs);
	}

}
