package com.spring.aopTest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
	@Test
    public void test1() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("aop2.xml");
		A a=(A) ac.getBean("person");
//		System.out.println(a.show3(111));
		a.show1();
    }
}
