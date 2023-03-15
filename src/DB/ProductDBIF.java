package DB;
import Model.Product;

public interface ProductDBIF {
	public Product findProduct(String name);
}
