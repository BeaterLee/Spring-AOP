package com.beater.spring.aop.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("AOPAnnotation.xml");
		Caculator caculator = (Caculator) ctx.getBean("caculatorAnnotation");
		System.out.println(caculator);
		caculator.add(3, 4);
		caculator.div(9, 3);
	}
}
