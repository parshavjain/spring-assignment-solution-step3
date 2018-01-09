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
public class LoggingAspect {
private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
    
    //UserAuth controller logs
    
@Before("execution(* com.stackroute.activitystream.controller.UserAuthController.login(..))")
    public void logBeforeAuthenticate(JoinPoint joinPoint) {
            logger.debug("Method Name : " + joinPoint.getSignature().getName());
    }
@After("execution(* com.stackroute.activitystream.controller.UserAuthController.login(..))")
    public void logAfterAuthenticate(JoinPoint joinPoint) {
        logger.debug("Method Name : " + joinPoint.getSignature().getName());
        logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
    }
@AfterReturning(pointcut = "execution(* com.stackroute.activitystream.controller.UserAuthController.login(..))", returning = "result")
    public void logAfterReturningAuthenticate(JoinPoint joinPoint, Object result) {
        logger.debug("Method Name : " + joinPoint.getSignature().getName());
        logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
    }
@AfterThrowing(pointcut = "execution(* com.stackroute.activitystream.controller.UserAuthController.login(..))", throwing = "error")
    public void logAfterThrowingAuthenticate(JoinPoint joinPoint, Throwable error) {
        logger.debug("Method Name : " + joinPoint.getSignature().getName());
        logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
        logger.debug("Exception : " + error);
    }
@Before("execution(* com.stackroute.activitystream.controller.UserAuthController.logout(..))")
public void logBeforeLogout(JoinPoint joinPoint) {
        logger.debug("Method Name : " + joinPoint.getSignature().getName());
}
@After("execution(* com.stackroute.activitystream.controller.UserAuthController.logout(..))")
public void logAfterLogout(JoinPoint joinPoint) {
    logger.debug("Method Name : " + joinPoint.getSignature().getName());
    logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
}
@AfterReturning(pointcut = "execution(* com.stackroute.activitystream.controller.UserAuthController.logout(..))", returning = "result")
public void logAfterReturningLogout(JoinPoint joinPoint, Object result) {
    logger.debug("Method Name : " + joinPoint.getSignature().getName());
    logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
}
@AfterThrowing(pointcut = "execution(* com.stackroute.activitystream.controller.UserAuthController.logout(..))", throwing = "error")
public void logAfterThrowingLogout(JoinPoint joinPoint, Throwable error) {
    logger.debug("Method Name : " + joinPoint.getSignature().getName());
    logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
    logger.debug("Exception : " + error);
}
//User controller logs
@Before("execution(* com.stackroute.activitystream.controller.UserController.getUsers(..))")
public void logBeforeGetUsers(JoinPoint joinPoint) {
        logger.debug("Method Name : " + joinPoint.getSignature().getName());
}
@After("execution(* com.stackroute.activitystream.controller.UserController.getUsers(..))")
public void logAfterGetUsers(JoinPoint joinPoint) {
    logger.debug("Method Name : " + joinPoint.getSignature().getName());
    logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
}
@AfterReturning(pointcut = "execution(* com.stackroute.activitystream.controller.UserController.getUsers(..))", returning = "result")
public void logAfterReturningGetUsers(JoinPoint joinPoint, Object result) {
    logger.debug("Method Name : " + joinPoint.getSignature().getName());
    logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
}
@AfterThrowing(pointcut = "execution(* com.stackroute.activitystream.controller.UserController.getUsers(..))", throwing = "error")
public void logAfterThrowingGetUsers(JoinPoint joinPoint, Throwable error) {
    logger.debug("Method Name : " + joinPoint.getSignature().getName());
    logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
    logger.debug("Exception : " + error);
}
@Before("execution(* com.stackroute.activitystream.controller.UserController.getUser(..))")
public void logBeforeGetUser(JoinPoint joinPoint) {
        logger.debug("Method Name : " + joinPoint.getSignature().getName());
}
@After("execution(* com.stackroute.activitystream.controller.UserController.getUser(..))")
public void logAfterGetUser(JoinPoint joinPoint) {
    logger.debug("Method Name : " + joinPoint.getSignature().getName());
    logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
}
@AfterReturning(pointcut = "execution(* com.stackroute.activitystream.controller.UserController.getUser(..))", returning = "result")
public void logAfterReturningGetUser(JoinPoint joinPoint, Object result) {
    logger.debug("Method Name : " + joinPoint.getSignature().getName());
    logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
}
@AfterThrowing(pointcut = "execution(* com.stackroute.activitystream.controller.UserController.getUser(..))", throwing = "error")
public void logAfterThrowingGetUser(JoinPoint joinPoint, Throwable error) {
    logger.debug("Method Name : " + joinPoint.getSignature().getName());
    logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
    logger.debug("Exception : " + error);
}
@Before("execution(* com.stackroute.activitystream.controller.UserController.createUser(..))")
public void logBeforeCreateUser(JoinPoint joinPoint) {
        logger.debug("Method Name : " + joinPoint.getSignature().getName());
}
@After("execution(* com.stackroute.activitystream.controller.UserController.createUser(..))")
public void logAfterCreateUser(JoinPoint joinPoint) {
    logger.debug("Method Name : " + joinPoint.getSignature().getName());
    logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
}
@AfterReturning(pointcut = "execution(* com.stackroute.activitystream.controller.UserController.createUser(..))", returning = "result")
public void logAfterReturningCreateUser(JoinPoint joinPoint, Object result) {
    logger.debug("Method Name : " + joinPoint.getSignature().getName());
    logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
}
@AfterThrowing(pointcut = "execution(* com.stackroute.activitystream.controller.UserController.createUser(..))", throwing = "error")
public void logAfterThrowingCreateUser(JoinPoint joinPoint, Throwable error) {
    logger.debug("Method Name : " + joinPoint.getSignature().getName());
    logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
    logger.debug("Exception : " + error);
}
//Message controller logs
@Before("execution(* com.stackroute.activitystream.controller.MessageController.sendMessageToCircle(..))")
public void logBeforeSendMessageToCircle(JoinPoint joinPoint) {
        logger.debug("Method Name : " + joinPoint.getSignature().getName());
}
@After("execution(* com.stackroute.activitystream.controller.MessageController.sendMessageToCircle(..))")
public void logAfterSendMessageToCircle(JoinPoint joinPoint) {
    logger.debug("Method Name : " + joinPoint.getSignature().getName());
    logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
}
@AfterReturning(pointcut = "execution(* com.stackroute.activitystream.controller.MessageController.sendMessageToCircle(..))", returning = "result")
public void logAfterReturningSendMessageToCircle(JoinPoint joinPoint, Object result) {
    logger.debug("Method Name : " + joinPoint.getSignature().getName());
    logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
}
@AfterThrowing(pointcut = "execution(* com.stackroute.activitystream.controller.MessageController.sendMessageToCircle(..))", throwing = "error")
public void logAfterThrowingSendMessageToCircle(JoinPoint joinPoint, Throwable error) {
    logger.debug("Method Name : " + joinPoint.getSignature().getName());
    logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
    logger.debug("Exception : " + error);
}
@Before("execution(* com.stackroute.activitystream.controller.MessageController.sendMessageToUser(..))")
public void logBeforeSendMessageToUser(JoinPoint joinPoint) {
        logger.debug("Method Name : " + joinPoint.getSignature().getName());
}
@After("execution(* com.stackroute.activitystream.controller.MessageController.sendMessageToUser(..))")
public void logAfterSendMessageToUser(JoinPoint joinPoint) {
    logger.debug("Method Name : " + joinPoint.getSignature().getName());
    logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
}
@AfterReturning(pointcut = "execution(* com.stackroute.activitystream.controller.MessageController.sendMessageToUser(..))", returning = "result")
public void logAfterReturningSendMessageToUser(JoinPoint joinPoint, Object result) {
    logger.debug("Method Name : " + joinPoint.getSignature().getName());
    logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
}
@AfterThrowing(pointcut = "execution(* com.stackroute.activitystream.controller.MessageController.sendMessageToUser(..))", throwing = "error")
public void logAfterThrowingSendMessageToUser(JoinPoint joinPoint, Throwable error) {
    logger.debug("Method Name : " + joinPoint.getSignature().getName());
    logger.debug("Method arguments : " + Arrays.toString(joinPoint.getArgs()));
    logger.debug("Exception : " + error);
}
}