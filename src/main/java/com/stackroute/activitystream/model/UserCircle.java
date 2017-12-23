package com.stackroute.activitystream.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * The class "UserCircle" will be acting as the data model for the user_circle Table in the database. Please
 * note that this class is annotated with @Entity annotation. Hibernate will scan all package for 
 * any Java objects annotated with the @Entity annotation. If it finds any, then it will begin the 
 * process of looking through that particular Java object to recreate it as a table in your database.
 *
 * Please note that you will have to use @Component annotation on this class if wish
 * to autowire the class from any other components of the application
 */

@SuppressWarnings("serial")
@Entity
@Component
@Table(name = "user_circle")
public class UserCircle implements Serializable {

	/*
	 * This class should have three fields (userCircleId,username,circleName). Out
	 * of these three fields, the field userCircleId should be the primary key and
	 * should be generated. This class should also contain the getters and setters
	 * for the fields.
	 */

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "userCircleId", nullable = false)
	private String userCircleId;

	@Column(name = "username")
	private String username;

	@Column(name = "circleName")
	private String circleName;

	@Autowired(required=false)
	public UserCircle(String username, String circleName) {
		this.username = username;
		this.circleName = circleName;
	}
	
	public UserCircle() {
		
	}

	/**
	 * @return the userCircleId
	 */
	
	public String getUserCircleId() {
		return userCircleId;
	}

	/**
	 * @param userCircleId
	 *            the userCircleId to set
	 */
	public void setUserCircleId(String userCircleId) {
		this.userCircleId = userCircleId;
	}

	/**
	 * @return the userName
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String username) {
		this.username = username;
	}

	/**
	 * @return the circleName
	 */
	public String getCircleName() {
		return circleName;
	}

	/**
	 * @param circleName
	 *            the circleName to set
	 */
	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}
}
