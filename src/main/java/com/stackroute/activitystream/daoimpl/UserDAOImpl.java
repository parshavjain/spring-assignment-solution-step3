package com.stackroute.activitystream.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.activitystream.dao.UserDAO;
import com.stackroute.activitystream.model.User;

/*
* This class is implementing the UserCircleDAO interface. This class has to be annotated with 
* @Repository annotation.
* @Repository - is an annotation that marks the specific class as a Data Access Object, 
* thus clarifying it's role.
* @Transactional - The transactional annotation itself defines the scope of a single database 
* 					transaction. The database transaction happens inside the scope of a persistence 
* 					context.  
* */
@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO{
	/*
	 * Autowiring should be implemented for the SessionFactory. 
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	/*
	 * Create a new user 
	 */
	public boolean save(User user) {
		boolean success = false;
		if(null != user) {
			sessionFactory.getCurrentSession().save(user);
			success = true;
		}
		return success;
	}

	/*
	 * Update an existing user 
	 */
	public boolean update(User user) {
		boolean success = false;
		if(null != user) {
			sessionFactory.getCurrentSession().update(user);
			success = true;
		}
		return success;
	}

	
	/*
	 * Remove an existing user 
	 */
	public boolean delete(User user) {
		boolean success = false;
		if(null != user) {
			sessionFactory.getCurrentSession().delete(user);
			success = true;
		}
		return success;
	}

	/*
	 * Retrieve all available user 
	 */
	public List<User> list() {
		List<User> userList = sessionFactory.getCurrentSession().createQuery("from user").list();
		return userList;
	}

	/*
	 * validate an user 
	 */
	public boolean validate(String id, String password) {
		if(null != id && null != password && !id.isEmpty() && !password.isEmpty()) {
			Query validateQuery = sessionFactory.getCurrentSession().createQuery("select count(*) from user where userName := id and password := password");
			validateQuery.setParameter("id", id);
			validateQuery.setParameter("password", password);
			Long countResults = (Long) validateQuery.uniqueResult();
			if(countResults == 1) {
				return true;
			}
		}
		return false;
	
	}

	/*
	 * Retrieve details of an user
	 */
	public User get(String id) {
		User user = null;
		if (null != id && !id.isEmpty()) {
			Query validateQuery = sessionFactory.getCurrentSession().createQuery("from user where userName := id ");
			validateQuery.setParameter("id", id);
			user = (User) validateQuery.getSingleResult();
		}
		return user;
	}
	
	/*
	 * check whether a user exists with a given userId 
	 */
	public boolean exists(String id) {
		if(null != id && !id.isEmpty()) {
			Query countQuery = sessionFactory.getCurrentSession().createQuery("select count(*) from user where userName := id ");
			countQuery.setParameter("id", id);
			Long countResults = (Long) countQuery.uniqueResult();
			if(countResults == 1) {
				return true;
			}
		}
		return false;
	}

}
