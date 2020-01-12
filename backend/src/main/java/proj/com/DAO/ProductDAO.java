package proj.com.DAO;

import java.util.List;

import proj.com.Model.Product;

public interface ProductDAO 
{
  public boolean addProduct(Product product);
  public boolean updateProduct(Product product);
  public boolean deleteProduct(Product product);
  public List<Product> listProducts();
  public Product getProduct(int prodid);
  public List<Product> listCategorywise(int catid);
  
}
