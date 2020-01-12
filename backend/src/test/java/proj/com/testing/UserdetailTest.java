package proj.com.testing;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import proj.com.DAO.UserDAO;
import proj.com.Model.Userdetail;

public class UserdetailTest 
{
  static UserDAO userdao;
  
  @BeforeClass
  public static void firstexe()
  {
	  AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	  context.scan("proj.com");
	  context.refresh();
	  userdao=(UserDAO) context.getBean("UserDAO");
	  
  }
@Test
public void addUserTest()
{
	Userdetail user=new Userdetail();
	user.setUsername("Harini");
	user.setPassword("123");
	user.setCity("Chennai");
	user.setContact("6655443377");
	user.setEmail("harini123@gmail.com");
	user.setStreet("West Anna Nagar");
	user.setRole("Role_User");
	user.setZip("678 897");
	assertTrue("Problem adding user informations",userdao.addUser(user));
	
}

}
