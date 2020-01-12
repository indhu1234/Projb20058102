package proj.com.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import proj.com.DAO.ProductDAO;
import proj.com.Model.Product;

@Repository("ProductDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO 
{

   @Autowired
   SessionFactory sessionFactory;
	
	@Override
	public boolean addProduct(Product product) {
		
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean updateProduct(Product product) {

		try
		{
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	@Override
	public boolean deleteProduct(Product product) {

		try
		{
			sessionFactory.getCurrentSession().delete(product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	@Override
	public List<Product> listProducts() {
		
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");
		List<Product> prodList=query.list();
		session.close();
		return prodList;
		
	}

	@Override
	public Product getProduct(int prodid) {
		Session session=sessionFactory.openSession();
		Product product=(Product) session.get(Product.class,prodid);
		session.close();
		return product;
		
	}

	@Override
	public List<Product> listCategorywise(int catid) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product where catid=:catid");
		query.setParameter("catid", catid);
		List<Product> productList=query.list();
		return productList;
		
	}

}
