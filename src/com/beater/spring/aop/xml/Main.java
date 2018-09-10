package com.beater.spring.aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Caculator caculator = (Caculator) ctx.getBean(Caculator.class);
		caculator.add(3, 4);
		caculator.div(9, 3);
	}
}
