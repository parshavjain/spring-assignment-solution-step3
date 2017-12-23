package com.stackroute.activitystream.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.activitystream.dao.CircleDAO;
import com.stackroute.activitystream.dao.MessageDAO;
import com.stackroute.activitystream.dao.UserCircleDAO;
import com.stackroute.activitystream.dao.UserDAO;
import com.stackroute.activitystream.model.Circle;
import com.stackroute.activitystream.model.Message;
import com.stackroute.activitystream.model.User;
import com.stackroute.activitystream.model.UserTag;

/*
* This class is implementing the MessageDAO interface. This class has to be annotated with 
* @Repository annotation.
* @Repository - is an annotation that marks the specific class as a Data Access Object, 
* thus clarifying it's role.
* @Transactional - The transactional annotation itself defines the scope of a single database 
* 					transaction. The database transaction happens inside the scope of a persistence 
* 					context.  
* */
@Repository("messageDAO")
@Transactional
public class MessageDAOImpl implements MessageDAO {

	/*
	 * Autowiring should be implemented for the SessionFactory.
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * Autowiring should be implemented for CircleDAO
	 */
	@Autowired
	private CircleDAO circleDAO;

	/*
	 * Autowiring should be implemented for UserDAO.
	 */
	@Autowired
	private UserDAO userDAO;

	/*
	 * Autowiring should be implemented for UserCircleDAO.
	 */
	@Autowired
	private UserCircleDAO userCircleDAO;

	public MessageDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * Retrieve messages from a specific circle. For improved performace, we will
	 * implement retrieving the messages partially by implementing pagination
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Message> getMessagesFromCircle(String circleName, int pageNumber) {
		List<Message> messageList = null;
		if (null != circleName) {
			// Query countQuery = sessionFactory.getCurrentSession().createQuery("select
			// count(*) from Circle where circleName := circleName");
			// countQuery.setParameter("circleName", circleName);
			// Long countResults = (Long) countQuery.uniqueResult();
			// int lastPageNumber = (int) (Math.ceil(countResults / pageNumber));

			Query selectQuery = sessionFactory.getCurrentSession()
					.createQuery("From Circle where circleName := circleName");
			selectQuery.setFirstResult(0);
			selectQuery.setMaxResults(pageNumber);
			messageList = selectQuery.list();
		}
		return messageList;
	}

	/*
	 * Retrieve messages between two users. Please note that in a one to one
	 * conversation, both users can act sometimes as a sender and sometimes as a
	 * recipient. For improved performace, we will implement retrieving the messages
	 * partially by implementing pagination
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Message> getMessagesFromUser(String userName, String otherUsername, int pageNumber) {
		List<Message> messages = null;
		if (null == userName || null != otherUsername) {
			Query query = sessionFactory.getCurrentSession()
					.createQuery("from Message where senderName := senderName and receiverId := receiverId");
			query.setParameter("senderName", userName);
			query.setParameter("receiverId", otherUsername);
			query.setFirstResult(0);
			query.setMaxResults(pageNumber);
			messages = query.list();
		}
		return messages;
	}

	/*
	 * Retrieve messages from all circles subscribed by a specific user. For
	 * improved performace, we will implement retrieving the messages partially by
	 * implementing pagination
	 */
	@SuppressWarnings("unchecked")
	public List<Message> getMessages(String userName, int pageNumber) {
		List<Message> messages = null;
		if (null != userName) {
			messages = sessionFactory.getCurrentSession().createQuery("from Message where circleName in (:circles)")
					.setParameterList("circles", userCircleDAO.getMyCircles(userName)).list();
		}
		return messages;
	}

	/*
	 * send messages from a specific circle. The posted message should have the
	 * current timestamp as the posted timestamp.
	 */
	public boolean sendMessageToCircle(String circleName, Message message) {
		try {
			if (null != message && null != message.getSenderName()) {
				User user = userDAO.get(message.getSenderName());
				if (null == user) {
					return false;
				}
				if (null != circleName) {
					Circle circle = circleDAO.get(circleName);
					if (null == circle) {
						return false;
					}
					message.setCircleName(circleName);
					sessionFactory.getCurrentSession().save(message);
					return true;
				}
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	/*
	 * Send message to a specific user
	 */
	public boolean sendMessageToUser(String username, Message message) {
		try {
			if (null != message && null != message.getSenderName()) {
				User user = userDAO.get(message.getSenderName());
				if (null == user) {
					return false;
				}
				if (null != username) {
					User receiver = userDAO.get(username);
					if (null == receiver) {
						return false;
					}
					message.setReceiverId(username);
					sessionFactory.getCurrentSession().save(message);
					return true;
				}
			}

		} catch (Exception e) {
			return false;
		}
		return false;
	}

	/*
	 * Retrieve all the tags available in the messages
	 */
	@SuppressWarnings("unchecked")
	public List<String> listTags() {
		return sessionFactory.getCurrentSession().createQuery("select DISTINCT('tag') from Message").list();
	}

	/*
	 * Retrieve all tags subscribed by a user
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<String> listMyTags(String userName) {
		List<String> tags = null;
		try {
			if (null != userName) {
				Query selectQuery = sessionFactory.getCurrentSession()
						.createQuery("select tag from Message where senderName := senderName");
				selectQuery.setParameter("senderName", userName);
				tags = selectQuery.list();
			}
		} catch (Exception e) {
			return tags;
		}
		return tags;
	}

	/*
	 * Retrieve all messages containing a specific tag. For improved performace, we
	 * will implement retrieving the messages partially by implementing pagination
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Message> showMessagesWithTag(String tag, int pageNumber) {
		List<Message> messages = null;
		if (null != tag) {
			Query query = sessionFactory.getCurrentSession().createQuery("from Message where tag := tag");
			query.setParameter("tag", tag);
			query.setFirstResult(0);
			query.setMaxResults(pageNumber);
			messages = query.list();
		}
		return messages;
	}

	/*
	 * Subscribe user to a tag. Please implement validation to check whether the
	 * user and tag both exists.
	 */
	public boolean subscribeUserToTag(String userName, String tag) {
		if (null != userName && null != tag) {
			UserTag userTag = new UserTag();
			userTag.setTag(tag);
			userTag.setUserName(userName);
			sessionFactory.getCurrentSession().save(userTag);
			return true;
		}
		return false;
	}

	/*
	 * Unsubscribe a user from a tag. Please implement validation to check whether
	 * the user has subscribed to the tag or not
	 */
	public boolean unsubscribeUserToTag(String userName, String tag) {
		if (null != userName && null != tag) {
			UserTag userTag = new UserTag();
			userTag.setTag(tag);
			userTag.setUserName(userName);
			sessionFactory.getCurrentSession().delete(userTag);
			return true;
		}
		return false;

	}

	/*
	 * Retrieve UserTag object for a username and a tag
	 */
	@SuppressWarnings("rawtypes")
	public UserTag getUserTag(String userName, String tag) {
		UserTag userTag = null;
		if (null != userName && null != tag && userName.isEmpty() && tag.isEmpty()) {
			Query searchQuery = sessionFactory.getCurrentSession()
					.createQuery("from userTag where userName := userName and tag := tag");
			searchQuery.setParameter("userName", userName);
			searchQuery.setParameter("tag", tag);
			userTag = (UserTag) searchQuery.getSingleResult();
		}
		return userTag;
	}

}
