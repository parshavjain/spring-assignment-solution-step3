package com.stackroute.activitystream.model;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/*
 * The class "Message" will be acting as the data model for the message Table in the database. Please
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
@Table(name = "message")
public class Message implements Serializable {

	/*
	 * This class should have eight fields
	 * (messageId,senderName,receiverId,circleName,postedDate,streamType,message,tag). Out of these eight fields, the
	 * field messageId should be auto-generated. This class should also contain
	 * the getters and setters for the fields. The value of postedDate should
	 * not be accepted from the user but should be always initialized with the
	 * system date
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "messageId", nullable = false)
	private Integer messageId;
	
	@Column(name = "senderName", nullable = false)
	private String sender;
	
	@Column(name = "receiverId", nullable = true)
	private String receiverId;
	
	@Column(name = "circleName", nullable= true)
	private String circleName;
	
	@Column(name = "postedDate")
	private Timestamp postedDate;
	
	@Column(name = "streamType", nullable = false)
	private String streamType;
	
	@Column(name = "message", nullable = false)
	private String message;
	
	@Column(name = "tag")
	private String tag;
	
	@Autowired(required=false)
	public Message(String senderName, String receiverId, String circleName, Timestamp postedDate, String streamType,
			String message, String tag) {
		this.sender = senderName;
		this.receiverId = receiverId;
		this.circleName = circleName;
		this.postedDate = postedDate;
		this.streamType = streamType;
		this.message = message;
		this.tag = tag;
		}
	
	public Message() {
		
	}
	
	/**
	 * @return the messageId
	 */
	public Integer getMessageId() {
		return messageId;
	}

	/**
	 * @param messageId
	 *            the messageId to set
	 */
	public void setMessageId(final Integer messageId) {
		this.messageId = messageId;
	}

	/**
	 * @return the senderName
	 */
	public String getSenderName() {
		return sender;
	}

	/**
	 * @param senderName
	 *            the senderName to set
	 */
	public void setSenderName(final String sender) {
		this.sender = sender;
	}

	/**
	 * @return the senderName
	 */
	public String getSender() {
		return getSenderName();
	}

	/**
	 * @param senderName
	 *            the senderName to set
	 */
	public void setSender(final String sender) {
		setSenderName(sender);
	}

	/**
	 * @return the postedDate
	 */
	public Timestamp getPostedDate() {
		return postedDate;
	}

	/**
	 * @param postedDate
	 *            the postedDate to set
	 */
	public void setPostedDate() {
		if (null == postedDate) {
			postedDate = new Timestamp(new Date().getTime());
		}
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(final String message) {
		this.message = message;
	}

	/**
	 * @return the receiverId
	 */
	public String getReceiverId() {
		return receiverId;
	}

	/**
	 * @param receiverId the receiverId to set
	 */
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}

	/**
	 * @return the circleName
	 */
	public String getCircleName() {
		return circleName;
	}

	/**
	 * @param circleName the circleName to set
	 */
	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}

	/**
	 * @return the streamType
	 */
	public String getStreamType() {
		return streamType;
	}

	/**
	 * @param streamType the streamType to set
	 */
	public void setStreamType(String streamType) {
		this.streamType = streamType;
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

	/*public void setMessage(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setStreamType(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setSenderName(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setTag(String string) {
		// TODO Auto-generated method stub
		
	}*/

}
