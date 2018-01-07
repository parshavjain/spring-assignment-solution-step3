package com.stackroute.activitystream.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/* Each of the methods of RestControllers has to be used in the given code snippet, any particular method will have all the four aspectJ annotation(@Before, @After, @AfterReturning, @AfterThrowing). 
Note: Provided is a sample using a single method, similarly you need to write for all the methods of RestControllers.*/

@Aspect
@Component
public class LoggingAspect {
	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	@Before("execution(* com.stackroute.activitystream.controller.UserAuthController.authenticate(..))")
	public void logBeforeAuthenticate(JoinPoint joinPoint) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.stackroute.activitystream.controller.UserAuthController.authenticate(..))")
	public void logAfterAuthenticate(JoinPoint joinPoint) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.stackroute.activitystream.controller.UserAuthController.authenticate(..))", returning = "result")
	public void logAfterReturningAuthenticate(JoinPoint joinPoint, Object result) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
	}

	@AfterThrowing(pointcut = "execution(* com.stackroute.activitystream.controller.UserAuthController.authenticate(..))", throwing = "error")
	public void logAfterThrowingAuthenticate(JoinPoint joinPoint, Throwable error) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
		logger.debug("Exception : " + error);
	}
	
	@Before("logForAllController()")
	public void logBeforeControllers(JoinPoint joinPoint) {
		logger.debug("Method Name : " + joinPoint.getSignature().getName());
		logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
	}

	@Pointcut("execution(* com.stackroute.activitystream.controller.*.*(..))")
	public void logForAllController() {

	}
}