package proj.com.DAO;

import java.util.List;

import proj.com.Model.Category;

public interface CategoryDAO 
{
  public boolean addCategory(Category category);
  public boolean updateCategory(Category category);
  public boolean deleteCategory(Category category);
  public List<Category> listCategories();
  public Category getCategory(int categoryId);
}
