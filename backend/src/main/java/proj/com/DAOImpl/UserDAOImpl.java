package proj.com.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import proj.com.DAO.UserDAO;
import proj.com.Model.Userdetail;

@Repository("UserDAO")
@Transactional
public class UserDAOImpl implements UserDAO
{

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public boolean addUser(Userdetail user) {
		try
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	@Override
	public boolean updateUser(Userdetail user) {
		try
		{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{ 
			return false;
		}
	}

	@Override
	public boolean deleteUser(Userdetail user) {
		try
		{
			sessionFactory.getCurrentSession().delete(user);
			return true;
		}
		catch(Exception e)
		{
		  return false;
		}
	}

	@Override
	public List<Userdetail> listUsers() {
		
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Userdetail");
		List<Userdetail> listusers=query.list();
		session.close();
		return listusers;
		
	}

	@Override
	public Userdetail getUser(int userid) {
		
		Session session=sessionFactory.openSession();
		Userdetail user1=(Userdetail) session.get(Userdetail.class, userid);
		session.close();
		return user1;
	}
   
}
