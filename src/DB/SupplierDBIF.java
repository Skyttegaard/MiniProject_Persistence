package DB;


import Model.Product;
import Model.Supplier;

public interface SupplierDBIF {
	public Supplier getSupplierInfo(Product product);

}
