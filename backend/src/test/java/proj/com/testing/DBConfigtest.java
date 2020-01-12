package proj.com.testing;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import proj.com.configuration.DBConfig;

public class DBConfigtest {

	public static void main(String[] args)
	{
		
	   AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	   context.scan("proj.com");
	   context.refresh();	  
	   System.out.println("Configuration success");
	} 

}
