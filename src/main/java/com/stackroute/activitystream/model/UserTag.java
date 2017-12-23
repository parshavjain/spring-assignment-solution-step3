package com.stackroute.activitystream.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/*
 * The class "UserTag" will be acting as the data model for the user_tag Table in the database. Please
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
@Table(name = "user_tag")
public class UserTag implements Serializable{
	
	/*
	 * This class should have three fields
	 * (userTagId,username,tag). Out of these three fields, the
	 * field userTagId should be the primary key and should be generated. This class 
	 * should also contain the getters and setters for the fields. 
	 */
	
	@Id
	@Column(name = "userTagId", nullable = false)
	private String userTagId;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "tag")
	private String tag;

	/**
	 * @return the userTagId
	 */
	public String getUserTagId() {
		return userTagId;
	}

	/**
	 * @param userTagId the userTagId to set
	 */
	public void setUserTagId(String userTagId) {
		this.userTagId = userTagId;
	}

	/**
	 * @return the userName
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String username) {
		this.username = username;
	}

	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	
	

}
