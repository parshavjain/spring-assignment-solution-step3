package com.stackroute.activitystream.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.activitystream.dao.UserDAO;
import com.stackroute.activitystream.model.User;

/*
* This class is implementing the UserDAO interface. This class has to be annotated with 
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
			sessionFactory.getCurrentSession().saveOrUpdate(user);
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
	@SuppressWarnings("unchecked")
	public List<User> list() {
		List<User> userList = sessionFactory.getCurrentSession().createQuery("from User").list();
		return userList;
	}

	/*
	 * validate an user 
	 */
	@SuppressWarnings("rawtypes")
	public boolean validate(String id, String password) {
		if(null != id && null != password && !id.isEmpty() && !password.isEmpty()) {
			Query validateQuery = sessionFactory.getCurrentSession().createQuery("select count(*) from User where username = :id and password = :password");
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
	@SuppressWarnings("rawtypes")
	public User get(String id) {
		User user = null;
		try {
			if (null != id && !id.isEmpty()) {
				Query validateQuery = sessionFactory.getCurrentSession().createQuery("from User u where u.username = :username");
				validateQuery.setParameter("username", id);
				user = (User) validateQuery.getSingleResult();
			}
		} catch(Exception ex) {
			return user;
		}		
		return user;
	}
	
	/*
	 * check whether a user exists with a given userId 
	 */
	@SuppressWarnings("rawtypes")
	public boolean exists(String id) {
		try {
		if(null != id && !id.isEmpty()) {
			Query countQuery = sessionFactory.getCurrentSession().createQuery("select count(*) from User where username = :id ");
			countQuery.setParameter("id", id);
			Long countResults = (Long) countQuery.uniqueResult();
			if(countResults > 0) {
				return true;
			}
		}
		} catch (Exception e) {
			return true;
		}
		return false;
	}

}
