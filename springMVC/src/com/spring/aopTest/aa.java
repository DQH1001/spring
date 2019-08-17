package com.spring.aopTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class aa implements A {

	@Override
	public void show1() {
		// TODO Auto-generated method stub
		System.out.println("show1");
	}

	@Override
	public String show2(String str) {
		// TODO Auto-generated method stub
		System.out.println("show2+"+str);
		return "return show2+"+str;
	}

	@Override
	public int show3(int str) {
		// TODO Auto-generated method stub
		System.out.println("show3+"+str);
		return str;
	}
	
	public static void main(String[] args) {
//		ApplicationContext ac=new ClassPathXmlApplicationContext("aopXML2.xml");
		ApplicationContext ac=new ClassPathXmlApplicationContext("aop2.xml");
		A a=(A) ac.getBean("person");
//		System.out.println(a.show3(111));
		a.show1();
	}
}
