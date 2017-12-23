package com.stackroute.activitystream.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.activitystream.dao.CircleDAO;
import com.stackroute.activitystream.dao.UserDAO;
import com.stackroute.activitystream.model.Circle;
import com.stackroute.activitystream.model.User;

/*
* This class is implementing the CircleDAO interface. This class has to be annotated with 
* @Repository annotation.
* @Repository - is an annotation that marks the specific class as a Data Access Object, 
* thus clarifying it's role.
* @Transactional - The transactional annotation itself defines the scope of a single database 
* 					transaction. The database transaction happens inside the scope of a persistence 
* 					context.  
* */
@Repository("circleDAO")
@Transactional
public class CircleDAOImpl implements CircleDAO {

	/*
	 * Autowiring should be implemented for the SessionFactory.
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * Autowiring should be implemented for UserDAO.
	 */
	@Autowired
	private UserDAO userDAO;

	/*
	 * Autowiring should be implemented for CircleDAO
	 */
	@Autowired
	private CircleDAO circleDAO;

	// Parameterized constructor.
	public CircleDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * Create a new circle
	 */
	public boolean save(Circle circle) {
		boolean success = false;
		try {
			if (null != circle && null != circle.getCreatorId()) {
				User user = userDAO.get(circle.getCreatorId());
				if (null == user) {
					return success;
				}
				Circle tempCircle = circleDAO.get(circle.getCircleName());
				if (null != tempCircle) {
					return success;
				}
					sessionFactory.getCurrentSession().save(circle);
					success = true;
			}

		} catch (Exception ex) {
			return success;
		}
		return success;
	}

	/*
	 * Update an existing circle
	 */
	public boolean update(Circle circle) {
		boolean success = false;
		if (null != circle) {
			sessionFactory.getCurrentSession().update(circle);
			success = true;
		}
		return success;
	}

	/*
	 * delete an existing circle
	 */
	public boolean delete(Circle circle) {
		boolean success = false;
		try {
			if (null != circle) {
				sessionFactory.getCurrentSession().delete(circle);
				success = true;
			}
		} catch (Exception e) {
			return success;
		}
		return success;
	}

	/*
	 * Retrieve a specific circle
	 */
	@SuppressWarnings("rawtypes")
	public Circle get(String circleName) {
		Circle circle = null;
		try {
			if (null != circleName) {
				Query query = sessionFactory.getCurrentSession()
						.createQuery("from Circle where circleName = :circleName");
				query.setParameter("circleName", circleName);
				circle = (Circle) query.getSingleResult();
			}
		} catch (Exception e) {
			return circle;
		}
		return circle;

	}

	/*
	 * retrieving all circles
	 */
	@SuppressWarnings("unchecked")
	public List<Circle> getAllCircles() {
		List<Circle> circleList = sessionFactory.getCurrentSession().createQuery("from Circle").list();
		return circleList;
	}

	/*
	 * Retrieving all circles that matches a search string
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Circle> getAllCircles(String searchString) {
		List<Circle> circleList = null;
		Query query = sessionFactory.getCurrentSession().createQuery("from Circle where circleName like :circleName");
		query.setParameter("circleName", "%" + searchString + "%");
		circleList = query.list();
		return circleList;
	}

}
