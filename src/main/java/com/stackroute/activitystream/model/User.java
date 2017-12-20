package com.stackroute.activitystream.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/*
 * The class "User" will be acting as the data model for the user Table in the database. Please
 * note that this class is annotated with @Entity annotation. Hibernate will scan all package for 
 * any Java objects annotated with the @Entity annotation. If it finds any, then it will begin the 
 * process of looking through that particular Java object to recreate it as a table in your database.
 *
 * Please note that you will have to use @Component annotation on this class if wish
 * to autowire the class from any other components of the application
 */

@Entity
@Component
@Table(name = "USER")
public class User {

	/*
	 * This class should have three fields
	 * (username,name,password). Out of these three fields, the
	 * field username should be the primary key. This class should also contain
	 * the getters and setters for the fields.
	 */
	
	@Id
	@Column(name = "userName", nullable = false)
	private String userName;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	public User(String userName, String name, String password) {
		this.userName = userName;
		this.name = name;
		this.password = password;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public void setName(String string) {
		this.name = string;
		
	}

	public void setPassword(String string) {
		this.password = password;		
	}

	public void setUsername(String string) {
		this.userName = string;
		
	}

	public String getPassword() {
		return this.password;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	
}
