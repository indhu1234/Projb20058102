package proj.com.testing;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import proj.com.DAO.ProductDAO;
import proj.com.Model.Product;

public class ProductDAOTest
{

	static ProductDAO prodao;
	@BeforeClass
	public static void executefirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("proj.com");
		context.refresh();
		prodao=(ProductDAO) context.getBean("ProductDAO");
	}
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProdname("Samsung Galaxy 1250");
		product.setProddesc("New Mobile Model");
		product.setQty(10);
		product.setPrice(18000);
		product.setCatid(1);
		assertTrue("Problem adding data",prodao.addProduct(product));
		
	}
	
	@Test
	public void updateTest()
	{
		Product product=prodao.getProduct(1);
		product.setPrice(20000);
		product.setQty(15);
		assertTrue("Problem while updating data",prodao.updateProduct(product));
		
	}
	@Test
	public void listTest()
	{
		List<Product> prodlist=prodao.listCategorywise(1);
		assertTrue("Problem in retrieving data ",prodlist.size()>0);
		
		for(Product product : prodlist)
		{
			System.out.println(product.getProdname());
		}
		
	}
}
