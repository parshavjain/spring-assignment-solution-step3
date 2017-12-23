package com.stackroute.activitystream.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.activitystream.dao.UserDAO;
import com.stackroute.activitystream.model.User;


/*
 * As in this assignment, we are working with creating RESTful web service, hence annotate
 * the class with @RestController annotation.A class annotated with @Controller annotation
 * has handler methods which returns a view. However, if we use @ResponseBody annotation along
 * with @Controller annotation, it will return the data directly in a serialized 
 * format. Starting from Spring 4 and above, we can use @RestController annotation which 
 * is equivalent to using @Controller and @ResposeBody annotation
 */
@RestController 
public class UserAuthController {

	/*
	 * Autowiring should be implemented for the UserDAO. Please note that 
	 * we should not create any object using the new keyword 
	 */
	@Autowired
	@Qualifier("userDAO")
	private UserDAO userDAO;
	
	
	

	/* Define a handler method which will authenticate a user by reading the Serialized user
	 * object from request body containing the username and password and validating the same. Post login, the 
	 * username will have to be stored into session object, so that we can check whether the user is logged in for all
	 * other services. 
	 * This handler method should return any one of the status messages basis on different
	 * situations:
	 * 1. 200(OK) - If login is successful
	 * 2. 401(UNAUTHORIZED) - If login is not successful
	 * 
	 * This handler method should map to the URL "/api/authenticate" using HTTP POST method
	*/
	@RequestMapping(value="/api/authenticate", method = RequestMethod.POST)
	public ResponseEntity<User> validate(@RequestBody User user, HttpSession session) {
		//null empty check.
		if (null == user || null == user.getPassword() || null == user.getUsername() || user.getUsername().isEmpty()
				|| user.getPassword().isEmpty()) {
			return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
		}
		
		//Validating username and password.
		//Service call.
		boolean success = userDAO.validate(user.getUsername(), user.getPassword());
		
		//Login success
		if(success) {
			User tempUser = userDAO.get(user.getUsername());
			if(null != tempUser) {
				session.setAttribute("userName", tempUser.getUsername());
				return new ResponseEntity<User>(tempUser, HttpStatus.OK);
			}			
		}
		
		//Login failed
		return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
	}
	
	

	/* Define a handler method which will perform logout. Post logout, the user session is to be destroyed.
	 * This handler method should return any one of the status messages basis on different
	 * situations:
	 * 1. 200(OK) - If logout is successful
	 * 2. 400(BAD REQUEST) - If logout has failed
	 * 
	 * This handler method should map to the URL "/api/logout" using HTTP PUT method
	*/ 
	@RequestMapping(value="/api/logout", method = RequestMethod.PUT)
	public ResponseEntity<User> logout(HttpSession session) {
		String loggedUserName = (String) session.getAttribute("userName");
		if (null == loggedUserName) {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST); 
		}
		session.removeAttribute("userName");
		session.invalidate();
		return new ResponseEntity<User>(HttpStatus.OK); 
	}


}
