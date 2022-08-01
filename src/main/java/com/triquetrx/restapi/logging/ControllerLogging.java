package com.triquetrx.restapi.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerLogging {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
	public void springApplication() {
	}

	@Pointcut("within(com.triquetrx.restapi..*)" + " || within(com.triquetrx.restapi.service..*)")
	public void applicationService() {
	}

	@Pointcut("within(com.triquetrx.restapi..*)" + " || within(com.triquetrx.restapi.controller..*)")
	public void applicationController() {
	}

	@Pointcut("execution(* *.*(..))")
	protected void allMethod() {
	}

	@Pointcut("execution(public * *(..))")
	protected void loggingPublicOperation() {
	}

	@Pointcut("execution(* *.*(..))")
	protected void loggingAllOperation() {
	}

	@Before("springApplication() && applicationController()")
	public void logBeforeController(JoinPoint joinPoint) {
		log.info("Application Controller Called for " + joinPoint.getSignature().getName());
	}
	
	@AfterThrowing(pointcut = "springApplication() && applicationController()", throwing = "e")
	public void logControllerError(JoinPoint joinPoint, Throwable e) {
		log.error("Exception in {}.{}() with cause = {}", joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName(), e.getCause() != null ? e.getCause() : "NULL");
	}
	
	@Before("springApplication() && applicationService()")
	public void logBeforeService(JoinPoint joinPoint) {
		log.info("Application Service Called for " + joinPoint.getSignature().getName());
	}
	
	@AfterThrowing(pointcut = "springApplication() && applicationService()", throwing = "e")
	public void logServiceError(JoinPoint joinPoint, Throwable e) {
		log.error("Exception in {}.{}() with cause = {}", joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName(), e.getCause() != null ? e.getCause() : "NULL");
	}

}
