package com.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonBean implements IPerson{
	
	public static void main(String[] args) {
		//ApplicationContext ac=new ClassPathXmlApplicationContext("aopXMl.xml");
		//使用aopXML配置文件中的配置(即使用InterceptorXML类的aop配置)
		//ApplicationContext ac=new ClassPathXmlApplicationContext("aop.xml");
		//使用aop配置文件中的配置(即使用InterceptorAnn类的aop注解配置)
		ApplicationContext ac=new ClassPathXmlApplicationContext("aop.xml");
        IPerson per=(IPerson)ac.getBean("person");
        System.out.println(per.getPersonname(1));
//        per.Save("");
	}

	@Override
	public void Save(String name) {
		// TODO Auto-generated method stub
		System.out.println("save "+name);
	}

	@Override
	public void Update(String name, Integer id) {
		// TODO Auto-generated method stub
		System.out.println("udpate "+name+id);
	}

	@Override
	public String getPersonname(Integer id) {
		System.out.println("get name "+id);
		return "jack";
	}

}
