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

/* Each of the methods of DAOImpls has to be used in the given code snippet, any particular method will have all the four aspectJ annotation(@Before, 
@After, @AfterReturning, @AfterThrowing). Note: Provided is a sample using a single method, similarly you need to write for all the methods of 
DAOImpls. */

@Aspect
public class DAOLoggingAspect {

	private static final Logger logger = LoggerFactory.getLogger(DAOLoggingAspect.class);
	//User DAO logs
	@Before("execution(* com.stackroute.activitystream.daoimpl.UserDAOImpl.validate(..))")
	public void logBeforeValidateUser(JoinPoint joinPoint) {
	    logger.info("============@Before==========");
	    logger.debug("Method Name : " + joinPoint.getSignature().getName());
	    logger.debug("*********************************");
	}
	@After("execution(* com.stackroute.activitystream.daoimpl.UserDAOImpl.validate(..))")
	public void logAfterValidateUser(JoinPoint joinPoint) {
	    logger.info("============@After==========");
	    logger.debug("Method Name : " + joinPoint.getSignature().getName());
	    logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
	    logger.debug("*********************************");
	}
	@AfterReturning(pointcut = "execution(* com.stackroute.activitystream.daoimpl.UserDAOImpl.validate(..))", returning = "result")
	public void logAfterReturningValidateUser(JoinPoint joinPoint, Object result) {
	    logger.debug("============@AfterReturning==========");
	    logger.debug("Method Name : " + joinPoint.getSignature().getName());
	    logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
	    logger.debug("*********************************");
	}
	@AfterThrowing(pointcut = "execution(* com.stackroute.activitystream.daoimpl.UserDAOImpl.validate(..))", throwing = "error")
	public void logAfterThrowingValidateUser(JoinPoint joinPoint, Throwable error) {
	    logger.info("============@AfterThrowing==========");
	    logger.debug("Method Name : " + joinPoint.getSignature().getName());
	    logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
	    logger.debug("Exception : " + error);
	    logger.debug("*********************************");
	}
	@Before("execution(* com.stackroute.activitystream.daoimpl.UserDAOImpl.save(..))")
	public void logBeforeSave(JoinPoint joinPoint) {
	    logger.info("============@Before==========");
	    logger.debug("Method Name : " + joinPoint.getSignature().getName());
	    logger.debug("*********************************");
	}
	@After("execution(* com.stackroute.activitystream.daoimpl.UserDAOImpl.save(..))")
	public void logAfterSave(JoinPoint joinPoint) {
	    logger.info("============@After==========");
	    logger.debug("Method Name : " + joinPoint.getSignature().getName());
	    logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
	    logger.debug("*********************************");
	}
	@AfterReturning(pointcut = "execution(* com.stackroute.activitystream.daoimpl.UserDAOImpl.save(..))", returning = "result")
	public void logAfterReturningSave(JoinPoint joinPoint, Object result) {
	    logger.debug("============@AfterReturning==========");
	    logger.debug("Method Name : " + joinPoint.getSignature().getName());
	    logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
	    logger.debug("*********************************");
	}
	@AfterThrowing(pointcut = "execution(* com.stackroute.activitystream.daoimpl.UserDAOImpl.save(..))", throwing = "error")
	public void logAfterThrowingSave(JoinPoint joinPoint, Throwable error) {
	    logger.info("============@AfterThrowing==========");
	    logger.debug("Method Name : " + joinPoint.getSignature().getName());
	    logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
	    logger.debug("Exception : " + error);
	    logger.debug("*********************************");
	}
	@Before("execution(* com.stackroute.activitystream.daoimpl.UserDAOImpl.delete(..))")
	public void logBeforeDelete(JoinPoint joinPoint) {
	    logger.info("============@Before==========");
	    logger.debug("Method Name : " + joinPoint.getSignature().getName());
	    logger.debug("*********************************");
	}
	@After("execution(* com.stackroute.activitystream.daoimpl.UserDAOImpl.delete(..))")
	public void logAfterDelete(JoinPoint joinPoint) {
	    logger.info("============@After==========");
	    logger.debug("Method Name : " + joinPoint.getSignature().getName());
	    logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
	    logger.debug("*********************************");
	}
	@AfterReturning(pointcut = "execution(* com.stackroute.activitystream.daoimpl.UserDAOImpl.delete(..))", returning = "result")
	public void logAfterReturningDelete(JoinPoint joinPoint, Object result) {
	    logger.debug("============@AfterReturning==========");
	    logger.debug("Method Name : " + joinPoint.getSignature().getName());
	    logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
	    logger.debug("*********************************");
	}
	@AfterThrowing(pointcut = "execution(* com.stackroute.activitystream.daoimpl.UserDAOImpl.delete(..))", throwing = "error")
	public void logAfterThrowingDelete(JoinPoint joinPoint, Throwable error) {
	    logger.info("============@AfterThrowing==========");
	    logger.debug("Method Name : " + joinPoint.getSignature().getName());
	    logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
	    logger.debug("Exception : " + error);
	    logger.debug("*********************************");
	}
	//Message DAO logs
	@Before("execution(* com.stackroute.activitystream.daoimpl.MessageDAOImpl.getMessagesFromCircle(..))")
	public void logBeforeGetMessagesFromCircle(JoinPoint joinPoint) {
	    logger.info("============@Before==========");
	    logger.debug("Method Name : " + joinPoint.getSignature().getName());
	    logger.debug("*********************************");
	}
	@After("execution(* com.stackroute.activitystream.daoimpl.MessageDAOImpl.getMessagesFromCircle(..))")
	public void logAfterGetMessagesFromCircle(JoinPoint joinPoint) {
	    logger.info("============@After==========");
	    logger.debug("Method Name : " + joinPoint.getSignature().getName());
	    logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
	    logger.debug("*********************************");
	}
	@AfterReturning(pointcut = "execution(* com.stackroute.activitystream.daoimpl.MessageDAOImpl.getMessagesFromCircle(..))", returning = "result")
	public void logAfterReturningGetMessagesFromCircle(JoinPoint joinPoint, Object result) {
	    logger.debug("============@AfterReturning==========");
	    logger.debug("Method Name : " + joinPoint.getSignature().getName());
	    logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
	    logger.debug("*********************************");
	}
	@AfterThrowing(pointcut = "execution(* com.stackroute.activitystream.daoimpl.MessageDAOImpl.getMessagesFromCircle(..))", throwing = "error")
	public void logAfterThrowingGetMessagesFromCircle(JoinPoint joinPoint, Throwable error) {
	    logger.info("============@AfterThrowing==========");
	    logger.debug("Method Name : " + joinPoint.getSignature().getName());
	    logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
	    logger.debug("Exception : " + error);
	    logger.debug("*********************************");
	}
	@Before("execution(* com.stackroute.activitystream.daoimpl.MessageDAOImpl.getMessagesFromUser(..))")
	public void logBeforeGetMessagesFromUser(JoinPoint joinPoint) {
	    logger.info("============@Before==========");
	    logger.debug("Method Name : " + joinPoint.getSignature().getName());
	    logger.debug("*********************************");
	}
	@After("execution(* com.stackroute.activitystream.daoimpl.MessageDAOImpl.getMessagesFromUser(..))")
	public void logAfterGetMessagesFromUser(JoinPoint joinPoint) {
	    logger.info("============@After==========");
	    logger.debug("Method Name : " + joinPoint.getSignature().getName());
	    logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
	    logger.debug("*********************************");
	}
	@AfterReturning(pointcut = "execution(* com.stackroute.activitystream.daoimpl.MessageDAOImpl.getMessagesFromUser(..))", returning = "result")
	public void logAfterReturningGetMessagesFromUser(JoinPoint joinPoint, Object result) {
	    logger.debug("============@AfterReturning==========");
	    logger.debug("Method Name : " + joinPoint.getSignature().getName());
	    logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
	    logger.debug("*********************************");
	}
	@AfterThrowing(pointcut = "execution(* com.stackroute.activitystream.daoimpl.MessageDAOImpl.getMessagesFromUser(..))", throwing = "error")
	public void logAfterThrowingGetMessagesFromUser(JoinPoint joinPoint, Throwable error) {
	    logger.info("============@AfterThrowing==========");
	    logger.debug("Method Name : " + joinPoint.getSignature().getName());
	    logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
	    logger.debug("Exception : " + error);
	    logger.debug("*********************************");
	}
	@Before("execution(* com.stackroute.activitystream.daoimpl.MessageDAOImpl.subscribeUserToTag(..))")
	public void logBeforesubscribeUserToTag(JoinPoint joinPoint) {
	    logger.info("============@Before==========");
	    logger.debug("Method Name : " + joinPoint.getSignature().getName());
	    logger.debug("*********************************");
	}
	@After("execution(* com.stackroute.activitystream.daoimpl.MessageDAOImpl.subscribeUserToTag(..))")
	public void logAftersubscribeUserToTag(JoinPoint joinPoint) {
	    logger.info("============@After==========");
	    logger.debug("Method Name : " + joinPoint.getSignature().getName());
	    logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
	    logger.debug("*********************************");
	}
	@AfterReturning(pointcut = "execution(* com.stackroute.activitystream.daoimpl.MessageDAOImpl.subscribeUserToTag(..))", returning = "result")
	public void logAfterReturningsubscribeUserToTag(JoinPoint joinPoint, Object result) {
	    logger.debug("============@AfterReturning==========");
	    logger.debug("Method Name : " + joinPoint.getSignature().getName());
	    logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
	    logger.debug("*********************************");
	}
	@AfterThrowing(pointcut = "execution(* com.stackroute.activitystream.daoimpl.MessageDAOImpl.subscribeUserToTag(..))", throwing = "error")
	public void logAfterThrowingsubscribeUserToTag(JoinPoint joinPoint, Throwable error) {
	    logger.info("============@AfterThrowing==========");
	    logger.debug("Method Name : " + joinPoint.getSignature().getName());
	    logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
	    logger.debug("Exception : " + error);
	    logger.debug("*********************************");
	}
}