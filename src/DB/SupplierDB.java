package DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.Product;
import Model.Supplier;

public class SupplierDB implements SupplierDBIF {
	private static final String getSupplierInfoStmt = "TODO";
	private PreparedStatement getSupplierInfo;
	
	private Supplier BuildObject(ResultSet rs) {
		//TODO
		return null;
	}
	
	public Supplier getSupplierInfo(Product product) {
		//TOOD
		return null;
	}

}
