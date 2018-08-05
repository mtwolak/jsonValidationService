package com.cs.validation.web;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Aspect
@Configuration
class ValidationAspect {

	private Logger logger = LoggerFactory.getLogger(ValidationAspect.class);

	@Around("execution(* com.cs.validation.web.ValidationController.*(..))")
	public Object before(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("Validation started for " + Arrays.toString(joinPoint.getArgs()));
		Object result = joinPoint.proceed();
		logger.info("Result of validation: " + result.toString());
		return result;
	}
}
