package com.stackroute.activitystream.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.activitystream.dao.CircleDAO;
import com.stackroute.activitystream.dao.UserCircleDAO;
import com.stackroute.activitystream.dao.UserDAO;
import com.stackroute.activitystream.model.Circle;
import com.stackroute.activitystream.model.User;
import com.stackroute.activitystream.model.UserCircle;

/*
* This class is implementing the UserCircleDAO interface. This class has to be annotated with 
* @Repository annotation.
* @Repository - is an annotation that marks the specific class as a Data Access Object, 
* thus clarifying it's role.
* @Transactional - The transactional annotation itself defines the scope of a single database 
* 					transaction. The database transaction happens inside the scope of a persistence 
* 					context.  
* */
@Repository("userCircleDAO")
@Transactional
public class UserCircleDAOImpl implements UserCircleDAO {

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

	public UserCircleDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * Add a user to a circle
	 */
	public boolean addUser(String userName, String circleName) {
		try {
			if (null != userName) {
				User user = userDAO.get(userName);
				if (null == user) {
					return false;
				}
			}

			if (null != circleName) {
				Circle circle = circleDAO.get(circleName);
				if (null == circle) {
					return false;
				}
			}
			
			UserCircle userCircle = new UserCircle(userName, circleName);
			sessionFactory.getCurrentSession().save(userCircle);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * Remove a user from a circle
	 */
	public boolean removeUser(String userName, String circleName) {
		try {
			if (null != userName) {
				User user = userDAO.get(userName);
				if (null == user) {
					return false;
				}
				Circle circle = circleDAO.get(circleName);
				if (null == circle) {
					return false;
				}
				UserCircle userCircle = new UserCircle(userName, circleName);
				sessionFactory.getCurrentSession().delete(userCircle);
				return true;
			}

		} catch (Exception e) {
			return false;
		}
		return false;
	}

	/*
	 * Retrieve unique UserCircle object which contains a specific username and
	 * circleName
	 */
	@SuppressWarnings("rawtypes")
	public UserCircle get(String userName, String circleName) {
		UserCircle userCircle = null;
		try {
			if (null != userName && null != circleName && !userName.isEmpty() && !circleName.isEmpty()) {
				Query query = sessionFactory.getCurrentSession()
						.createQuery("from UserCircle where userName = :userName and circleName = :circleName");
				query.setParameter("userName", userName);
				query.setParameter("circleName", circleName);
				userCircle = (UserCircle) query.getSingleResult();
			}
		} catch (Exception ex) {
			return userCircle;
		}
		return userCircle;
	}

	/*
	 * Retrieve all subscribed circles by a user
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<String> getMyCircles(String userName) {
		List<String> userCircleList = null;
		try {
			if (null != userName) {
				User user = userDAO.get(userName);
				if (null == user) {
					return userCircleList;
				}
			}
			Query query = sessionFactory.getCurrentSession()
					.createQuery("select uc.circleName from UserCircle uc where uc.username = :userName");
			query.setParameter("userName", userName);
			userCircleList = query.list();
		} catch (Exception ex) {
			return userCircleList;
		}
		return userCircleList;
	}

}
