package com.beater.spring.aop.annotation;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
//@Aspect声明该类是切面
@Aspect
public class AspectLogging {

//	// 声明该方法为前置通知：在目标方法开始之前执行
//	@Before("execution(public int com.beater.spring.aop.annotation.Caculator.*(int, int))")
//	public void beforeMethod(JoinPoint joinPoint) {
//		String methodName = joinPoint.getSignature().getName();
//		List<Object> args = Arrays.asList(joinPoint.getArgs());
//		System.out.println("The method " + methodName + " begin with" + args);
//	}
//
//	// 声明该方法为后置通知：在目标方法执行后（无论是否发生异常）执行的通知
//	@After("execution(public int com.beater.spring.aop.annotation.Caculator.*(..))")
//	public void afterMethod(JoinPoint joinPoint) {
//		String methodName = joinPoint.getSignature().getName();
//		System.out.println("The method " + methodName + " end");
//	}
//	
//	// 设置returning属性，可获得目标方法执行返回值，该值作为入参
	// 声明该方法为返回通知：在方法返回结果之后执行
//	@AfterReturning(value = "execution(public int com.beater.spring.aop.annotation.Caculator.*(..))", returning = "result")
//	public void afterReturningMethod(JoinPoint joinPoint, Object result) {
//		String methodName = joinPoint.getSignature().getName();
//		System.out.println("The method " + methodName + " end with " + result);
//	}
//
	// 设置throwing属性，可获得目标方法执行过程的异常，该值作为入参
	// 声明该方法为异常通知, 在方法抛出异常之后执行
//	@AfterThrowing(value = "execution(public int com.beater.spring.aop.annotation.Caculator.*(..))", throwing = "e")
//	public void afterThrowingMethod(JoinPoint joinPoint, Exception e) {
//		String methodName = joinPoint.getSignature().getName();
//		System.out.println("The method " + methodName + " occured error with " + e);
//	}
	
	//使用Pointcut注解声明切入点，Pointcut注解的方法不需要再写代码，使用切入点时在value处填入方法名即可,该切入点可被重用
	@Pointcut("execution(public int com.beater.spring.aop.annotation.Caculator.*(..))")
	public void pointCut() {}
	//环绕通知必须要有返回值
	@Around(value = "pointCut()")
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
