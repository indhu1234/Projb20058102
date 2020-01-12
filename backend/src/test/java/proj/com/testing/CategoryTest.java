package proj.com.testing;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.hibernate.annotations.SelectBeforeUpdate;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import junit.framework.TestCase;
import proj.com.DAO.CategoryDAO;
import proj.com.Model.Category;

public class CategoryTest
{
	static CategoryDAO catdao;
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("proj.com");
		context.refresh();
		catdao=(CategoryDAO) context.getBean("CategoryDAO");
	}
    
	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		/*category.setCatname("Mobile");
		category.setDesc("All Models");
*/	//    category.setCatid(10);
		category.setCatname("Computer Accessories");
		category.setDesc("All Models");
		/*category.setCatname("Mobile Accessories");
		category.setDesc("All Models");*/
		catdao.addCategory(category);
	}
	
@Ignore
@Test
public void updatecategoryTest()
{
	Category category=catdao.getCategory(1);
	category.setDesc("All models of mobiles");
	assertTrue("Problem occured while update",catdao.updateCategory(category));
	
	
}

@Ignore
@Test
public void deletecategoryTest()
{
	Category category=catdao.getCategory(1);
	assertTrue("Problem occurred while deleting",catdao.deleteCategory(category));
	
}

@Ignore
@Test
public void listcategoriesTest()
{
	List<Category> catlist=catdao.listCategories();
	assertTrue("Problem occurred while listing datas",catlist.size()>0);
	for(Category category:catlist)
	{
		System.out.println(category.getCatid());
		System.out.println(category.getCatname());
		System.out.println(category.getDesc());
		
	}
	
}

}
