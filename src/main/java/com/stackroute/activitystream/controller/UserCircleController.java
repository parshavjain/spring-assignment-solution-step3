package com.stackroute.activitystream.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.activitystream.dao.CircleDAO;
import com.stackroute.activitystream.dao.UserCircleDAO;
import com.stackroute.activitystream.dao.UserDAO;
import com.stackroute.activitystream.model.Circle;
import com.stackroute.activitystream.model.User;
import com.stackroute.activitystream.model.UserCircle;

/*
 * As in this assignment, we are working with creating RESTful web service, hence annotate
 * the class with @RestController annotation.A class annotated with @Controller annotation
 * has handler methods which returns a view. However, if we use @ResponseBody annotation along
 * with @Controller annotation, it will return the data directly in a serialized 
 * format. Starting from Spring 4 and above, we can use @RestController annotation which 
 * is equivalent to using @Controller and @ResposeBody annotation
 */
@RestController
public class UserCircleController {

	/*
	 * Autowiring should be implemented for the
	 * UserDAO,UserCircleDAO,CircleDAO,UserCircle. Please note that we should not
	 * create any object using the new keyword
	 */
	@Autowired
	@Qualifier("userDAO")
	private UserDAO userDAO;

	@Autowired
	@Qualifier("userCircleDAO")
	private UserCircleDAO userCircleDAO;

	@Autowired
	@Qualifier("circleDAO")
	private CircleDAO circleDAO;


	/*
	 * Define a handler method which will add a user to a circle.
	 * 
	 * This handler method should return any one of the status messages basis on
	 * different situations: 1. 200(OK) - If the user is added to the circle 2.
	 * 500(INTERNAL SERVER ERROR) - If there are any errors 3. 401(UNAUTHORIZED) -
	 * If the user is not logged in 4. 404(NOT FOUND) - if the username or the
	 * circle does not exist 5. 409(CONFLICT) - if the user is already added to the
	 * circle
	 * 
	 * This handler method should map to the URL
	 * "/api/usercircle/addToCircle/{username}/{circleName}" using HTTP PUT method"
	 * where "username" should be replaced by a valid username without {} and
	 * "circleName" should be replaced by a valid circle name without {}
	 */
	@RequestMapping(value = "/api/usercircle/addToCircle/{username}/{circleName}", method = RequestMethod.PUT)
	private ResponseEntity<UserCircle> addToCircle(@PathVariable("username") String username,
			@PathVariable("circleName") String circleName, HttpSession session) {
		String loggedUserName = (String) session.getAttribute("userName");
		if (null == loggedUserName) {
			return new ResponseEntity<UserCircle>(HttpStatus.UNAUTHORIZED);
		}

		if (null != username) {
			User user = userDAO.get(username);
			if (null == user) {
				return new ResponseEntity<UserCircle>(HttpStatus.NOT_FOUND);
			}
		}
		if (null != circleName) {
			Circle circle = circleDAO.get(circleName);
			if (null == circle) {
				return new ResponseEntity<UserCircle>(HttpStatus.NOT_FOUND);
			}
		}

		UserCircle userCircle = userCircleDAO.get(username, circleName);

		if (null == userCircle) {
			boolean success = userCircleDAO.addUser(username, circleName);
			if (success) {
				return new ResponseEntity<UserCircle>(HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<UserCircle>(HttpStatus.CONFLICT);
		}

		return new ResponseEntity<UserCircle>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/*
	 * Define a handler method which will remove a user from a circle.
	 * 
	 * This handler method should return any one of the status messages basis on
	 * different situations: 1. 200(OK) - If the user is remove from the circle 2.
	 * 500(INTERNAL SERVER ERROR) - If there are any errors 3. 401(UNAUTHORIZED) -
	 * If the user is not logged in
	 * 
	 * This handler method should map to the URL
	 * "/api/usercircle/removeFromCircle/{username}/{circleName}" using HTTP PUT
	 * method" where "username" should be replaced by a valid username without {}
	 * and "circleName" should be replaced by a valid circle name without {}
	 */
	@RequestMapping(value = "/api/usercircle/removeFromCircle/{username}/{circleName}", method = RequestMethod.PUT)
	private ResponseEntity<UserCircle> removeFromCircle(@PathVariable("username") String userName,
			@PathVariable("circleName") String circleName, HttpSession session) {
		String loggedUserName = (String) session.getAttribute("userName");
		if (null == loggedUserName) {
			return new ResponseEntity<UserCircle>(HttpStatus.UNAUTHORIZED);
		}

		if (null != circleName) {
			boolean success = userCircleDAO.removeUser(userName, circleName);
			if (success) {
				return new ResponseEntity<UserCircle>(HttpStatus.OK);
			}
		}
		return new ResponseEntity<UserCircle>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/*
	 * Define a handler method which will get us the subscribed circles by a user.
	 * 
	 * This handler method should return any one of the status messages basis on
	 * different situations: 1. 200(OK) - If the user is added to the circle 2.
	 * 401(UNAUTHORIZED) - If the user is not logged in
	 * 
	 * This handler method should map to the URL
	 * "/api/usercircle/searchByUser/{username}" using HTTP GET method where
	 * "username" should be replaced by a valid username without {}
	 */
	@RequestMapping(value = "/api/usercircle/searchByUser/{username}", method = RequestMethod.GET)
	private ResponseEntity<List<String>> searchByUser(@PathVariable("username") String username, HttpSession session) {
		String loggedUserName = (String) session.getAttribute("userName");
		if (null == loggedUserName) {
			return new ResponseEntity<List<String>>(HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<List<String>>(userCircleDAO.getMyCircles(username), HttpStatus.OK);
	}

}
