package com.beater.spring.aop.xml;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;


public class AspectLogging {

	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method " + methodName + " begin with" + args);
	}

	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " end");
	}

	public void afterReturningMethod(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " end with " + result);
	}

	public void afterThrowingMethod(JoinPoint joinPoint, Exception e) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " occured error with " + e);
	}
	
	//环绕通知必须要有返回值
	public Object aroundMethod(ProceedingJoinPoint pjp) {
		Object result = null;
		String methodName = pjp.getSignature().getName();
		List<Object> args = Arrays.asList(pjp.getArgs());
		try {
			// 前置通知
			System.out.println("The method " + methodName + " begin with" + args);
			result = pjp.proceed();
			// 返回通知
			System.out.println("The method " + methodName + " end with " + result);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			// 异常通知
			System.out.println("The method " + methodName + " occured error with " + e);
			throw new RuntimeException(e);
		}
		// 后置通知
		System.out.println("The method " + methodName + " end");
		return result;
	}
}
