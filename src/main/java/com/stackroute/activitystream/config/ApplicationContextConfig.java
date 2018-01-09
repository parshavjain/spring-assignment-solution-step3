package com.stackroute.activitystream.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.stackroute.activitystream.aspect.DAOLoggingAspect;
import com.stackroute.activitystream.aspect.LoggingAspect;
import com.stackroute.activitystream.dao.CircleDAO;
import com.stackroute.activitystream.dao.MessageDAO;
import com.stackroute.activitystream.dao.UserCircleDAO;
import com.stackroute.activitystream.dao.UserDAO;
import com.stackroute.activitystream.daoimpl.CircleDAOImpl;
import com.stackroute.activitystream.daoimpl.MessageDAOImpl;
import com.stackroute.activitystream.daoimpl.UserCircleDAOImpl;
import com.stackroute.activitystream.daoimpl.UserDAOImpl;
import com.stackroute.activitystream.model.Circle;
import com.stackroute.activitystream.model.Message;
import com.stackroute.activitystream.model.User;
import com.stackroute.activitystream.model.UserCircle;
import com.stackroute.activitystream.model.UserTag;

/**
 * This class will contain the application-context for the application. 
 * Define the following annotations:
 * @Configuration - Annotating a class with the @Configuration indicates that the 
 *                  class can be used by the Spring IoC container as a source of 
 *                  bean definitions
 * @ComponentScan - this annotation is used to search for the Spring components amongst the application
 * @EnableWebMvc - Adding this annotation to an @Configuration class imports the Spring MVC 
 * 				   configuration from WebMvcConfigurationSupport 
 * @EnableTransactionManagement - Enables Spring's annotation-driven transaction management capability.
 *                  
 * 
 **/

@EnableWebMvc
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.stackroute.activitystream")

@EnableAspectJAutoProxy
public class ApplicationContextConfig {

	/**
	 * Define the bean for DataSource. In our application, we are using MySQL as the dataSource.
	 * To create the DataSource bean, we need to know:
	 * 1. Driver class name
	 * 2. Database URL
	 * 3. Username
	 * 4. Password
	 */
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();		
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://localhost:3306/activitystream_step3");
	    dataSource.setUsername("root");
	    dataSource.setPassword("P@ssw0rd");
	    return dataSource;
	}
	/*public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();		
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://localhost:3306/" + System.getenv("MYSQL_DATABASE"));
	    dataSource.setUsername(System.getenv("MYSQL_USER"));
	    dataSource.setPassword(System.getenv("MYSQL_PASSWORD"));
	    return dataSource;
	}*/
	
	
	/**
	 * Define the bean for SessionFactory. Hibernate SessionFactory is the factory class 
	 * through which we get sessions and perform database operations. 
	 */
	
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
	 
	    LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	 
	    sessionBuilder.addAnnotatedClasses(Message.class);
	    sessionBuilder.addAnnotatedClasses(Circle.class);
	    sessionBuilder.addAnnotatedClasses(User.class);
	    sessionBuilder.addAnnotatedClasses(UserCircle.class);
	    sessionBuilder.addAnnotatedClasses(UserTag.class);
	    sessionBuilder.addProperties(getHibernateProperties());
	 
	    return sessionBuilder.buildSessionFactory();
	}
	
	private Properties getHibernateProperties() {
	    Properties properties = new Properties();
	    properties.put("hibernate.show_sql", "true");
	    properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	    properties.put("hibernate.hbm2ddl.auto", "update");
	    return properties;
	}
	
	/**
	 * Define the bean for Transaction Manager. HibernateTransactionManager handles transaction 
	 * in Spring. The application that uses single hibernate session factory for database transaction
	 * has good choice to use HibernateTransactionManager. HibernateTransactionManager can work with 
	 * plain JDBC too. HibernateTransactionManager allows bulk update and bulk insert and ensures 
	 * data integrity.   
	 */
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
	    HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
	    return transactionManager;
	}

	/*@Autowired
	@Bean(name = "messageDAO")
	public MessageDAO getMessageDAO(SessionFactory sessionFactory) {
	    return new MessageDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name = "circleDAO")
	public CircleDAO getCircleDAO(SessionFactory sessionFactory) {
	    return new CircleDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name = "userCircleDAO")
	public UserCircleDAO getUserCircleDAO(SessionFactory sessionFactory) {
	    return new UserCircleDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name = "userDAO")
	public UserDAO getUserDAO(SessionFactory sessionFactory) {
	    return new UserDAOImpl(sessionFactory);
	}*/
	
	
	@Bean
	public DAOLoggingAspect getDAOLoggingAspect() {
	    return new DAOLoggingAspect();
	}
	
	@Bean
	public LoggingAspect getLoggingAspect() {
	    return new LoggingAspect();
	}
}
