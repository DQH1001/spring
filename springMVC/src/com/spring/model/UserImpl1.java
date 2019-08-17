package com.spring.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.reference.Iusers;

public class UserImpl1 implements IUser {
	IComps com=null;
	//name="coms"   ioc容器读取app..配置文件依赖注入后动态调用该setter方法，
//	注入到com对象为反射实例要调用，也就是依赖注入的com1对象的反射Object实例对象
	public void setComs(IComps com) {
//		<property name="coms" ref="com1"></property>
		System.out.println("setter注入1，依赖注入的第一种方式:"+com);
		
		this.com = com;
	}

	public UserImpl1() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int SaveUsers(String name) {
		System.out.println("save user1 "+name);
		//看不出调用哪个实现类的方法体
		System.out.println(this.com.SaveComps(name));
		return 1;
	}
	public static void main(String[] args) {
		//启动ioc容器
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml"); 
		IUser user=(IUser)ac.getBean("users1");
		System.out.println("自动装配");
		System.out.println(user.SaveUsers("aaa"));
	}

	

}
