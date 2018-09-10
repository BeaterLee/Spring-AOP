package com.beater.spring.aop.annotation;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//order指定切面的优先级，值越小优先级越高
@Order(1)
@Component
//@Aspect声明该类是切面
@Aspect
public class AspectValidate {
	
	@Before("com.beater.spring.aop.annotation.AspectLogging.pointCut()")
	public void validate(JoinPoint joinPoint) {
		System.out.println("validate:" + Arrays.asList(joinPoint.getArgs()));
	}
}
