package com.stackroute.activitystream.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.activitystream.dao.CircleDAO;
import com.stackroute.activitystream.dao.UserCircleDAO;
import com.stackroute.activitystream.dao.UserDAO;
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
	
	public UserCircleDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * Add a user to a circle
	 */
	public boolean addUser(String userName, String circleName) {
		if (null != userName && null != circleName && !userName.isEmpty() && !circleName.isEmpty()) {
			UserCircle userCircle = new UserCircle(userName, circleName);
			sessionFactory.getCurrentSession().save(userCircle);
			return true;
		}
		return false;
	}

	/*
	 * Remove a user from a circle
	 */
	public boolean removeUser(String userName, String circleName) {
		if (null != userName && null != circleName && !userName.isEmpty() && !circleName.isEmpty()) {
			UserCircle userCircle = new UserCircle(userName, circleName);
			sessionFactory.getCurrentSession().delete(userCircle);
			return true;
		}
		return false;
	}

	/*
	 * Retrieve unique UserCircle object which contains a specific username and
	 * circleName
	 */
	public UserCircle get(String userName, String circleName) {
		UserCircle userCircle = null;
		if (null != userName && null != circleName && !userName.isEmpty() && !circleName.isEmpty()) {
			Query query = sessionFactory.getCurrentSession()
					.createQuery("from userCircle where userName := userName and circleName := circleName");
			query.setParameter("userName", userName);
			query.setParameter("circleName", circleName);
			userCircle = (UserCircle) query.getSingleResult();
		}
		return userCircle;
	}

	/*
	 * Retrieve all subscribed circles by a user
	 */
	@SuppressWarnings("unchecked")
	public List<String> getMyCircles(String userName) {
		List<String> userircleList = null;
		if (null != userName && !userName.isEmpty() ) {
			Query query = sessionFactory.getCurrentSession()
					.createQuery("select circleName from userCircle where userName := userName");
			query.setParameter("userName", userName);
			userircleList = query.list();
		}
		return userircleList;
	}

}
