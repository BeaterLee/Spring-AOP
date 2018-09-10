package com.beater.spring.aop.xml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

public class AspectValidate {
	
	public void validate(JoinPoint joinPoint) {
		System.out.println("validate:" + Arrays.asList(joinPoint.getArgs()));
	}
}
