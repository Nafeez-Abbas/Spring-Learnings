package com.learnings.log;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Aspect
@Slf4j
@Component
public class LoggingAspect {
	
	@Pointcut(value = "within(com.learnings..*)")
	private void applicationPointCut() {}
	
	@Around(value = "applicationPointCut()")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		if (log.isInfoEnabled()) {
			log.info("Execution started :: {}.{}() with arguments = {}", 
					joinPoint.getSignature().getDeclaringTypeName(),
					joinPoint.getSignature().getName(),
					Arrays.toString(joinPoint.getArgs()));
		}
		Object result = joinPoint.proceed();
		if (log.isInfoEnabled()) {
			log.info("Execution ended :: {}.{}() with result = {}",
					joinPoint.getSignature().getDeclaringTypeName(),
					joinPoint.getSignature().getName(), result);
		}
		return result;
	}
	
}
