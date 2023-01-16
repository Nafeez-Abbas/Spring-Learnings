package com.learnings.log;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

	@Pointcut(value = "within(com.learnings..*)")
	private void applicationPointCut() {}
	
	@Around(value = "applicationPointCut()")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("Execution started :: {}.{}() with arguments = {}", 
					joinPoint.getSignature().getDeclaringTypeName(),
					joinPoint.getSignature().getName(),
					Arrays.toString(joinPoint.getArgs()));
		}
		Object result = joinPoint.proceed();
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("Execution ended :: {}.{}() with result = {}",
					joinPoint.getSignature().getDeclaringTypeName(),
					joinPoint.getSignature().getName(), result);
		}
		return result;
	}
	
}
