package proj.com.configuration;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import proj.com.Model.Category;
import proj.com.Model.Product;
import proj.com.Model.Userdetail;

@Configuration
@EnableTransactionManagement

public class DBConfig
{
    @Bean(name="dataSource")
	public DataSource getH2DataSource() {
		DriverManagerDataSource  datasource=new DriverManagerDataSource();
		
		datasource.setDriverClassName("org.h2.Driver");
		datasource.setUrl("jdbc:h2:tcp://localhost/~/proj58102");
		datasource.setUsername("sa");
		datasource.setPassword("sa");

		System.out.println("===Creating DataSource Bean==");
		return datasource;
		
	}
	@Bean
    public SessionFactory getsessionFactory() 
	{
	Properties hibernateproperties=new Properties();
		hibernateproperties.put("hibernate.hbm2ddl.auto","update");
		
		hibernateproperties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		hibernateproperties.put("hibernate.show_sql", true);
		hibernateproperties.put("hibernate.format_sql", true);
		LocalSessionFactoryBuilder factory1=new LocalSessionFactoryBuilder(this.getH2DataSource());
		factory1.addProperties(hibernateproperties)	;
		
		factory1.addAnnotatedClass(Category.class);
		factory1.addAnnotatedClass(Product.class);
		factory1.addAnnotatedClass(Userdetail.class);
		
		SessionFactory sessionFactory=factory1.buildSessionFactory();
		System.out.println("===Creating the SessionFactory Bean====");
		return sessionFactory;
		
	}
    @Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("Creating the TransactionManager Bean");
		return new HibernateTransactionManager(sessionFactory);
		
	}

}
