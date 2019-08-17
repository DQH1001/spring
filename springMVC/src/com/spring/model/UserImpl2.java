package com.spring.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.reference.Iusers;

public class UserImpl2 implements IUser {
	IComps com=null;
	int number;

	public UserImpl2() {
		// TODO Auto-generated constructor stub
	}
	public UserImpl2(IComps com) {
		// TODO Auto-generated constructor stub
		this.com=com;
	}
	public UserImpl2(IComps com,int number) {
		// TODO Auto-generated constructor stub
		this.com=com;
		this.number=number;
		System.out.println("构造注入:"+com+"--"+number);
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
		ApplicationContext ac=new ClassPathXmlApplicationContext("app.xml"); 
		IUser user=(IUser)ac.getBean("users");
		System.out.println("构造注入");
		System.out.println(user.SaveUsers("aaa"));
	}

	

}
