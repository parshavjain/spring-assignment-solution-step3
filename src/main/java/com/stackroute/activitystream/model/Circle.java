package com.stackroute.activitystream.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * The class "Circle" will be acting as the data model for the circle Table in the database. Please
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
@Table(name = "circle")
public class Circle implements Serializable {

	/*
	 * This class should have three fields
	 * (circleName,creatorId,createdDate). Out of these three fields, the
	 * field circleName should be the primary key. This class should also contain
	 * the getters and setters for the fields. The value of createdDate should
	 * not be accepted from the user but should be always initialized with the
	 * system date
	 */
	
	@Id
	@Column(name = "circleName", nullable = false)
	private String circleName;
	
	/**
	 * @return the createdDate
	 */
	public Timestamp getCreatedDate() {
		return createdDate;
	}

	/**
	 * @return the creatorId
	 */
	public String getCreatorId() {
		return creatorId;
	}

	private String creatorId;
	
	private Timestamp createdDate;
	
	@Autowired(required=false)
	public Circle(String circleName, String creatorId, Timestamp timeStamp) {
		this.circleName = circleName;
		this.creatorId = creatorId;
		this.createdDate = timeStamp;
	}

	public Circle() {
		// TODO Auto-generated constructor stub
	}

	public void setCircleName(String string) {
		this.circleName = string;
		
	}

	public void setCreatedDate() {
		this.createdDate = new Timestamp(new Date().getTime());		
	}

	public void setCreatorId(String string) {
		this.creatorId = string;
		
	}

	public String getCircleName() {
		return circleName;
	}
}
