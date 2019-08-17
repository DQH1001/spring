package com.spring.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.reference.Iusers;

public class UserImpl implements IUser {
	IComps com=null;
	//name="coms"   ioc容器读取app..配置文件依赖注入后动态调用该setter方法，
//	注入到com对象为反射实例要调用，也就是依赖注入的com1对象的反射Object实例对象
	public void setComs(IComps com) {
//		<property name="coms" ref="com1"></property>
		System.out.println("setter注入，依赖注入的第一种方式:"+com);
		
		this.com = com;
	}

	public UserImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int SaveUsers(String name) {
		System.out.println("save user "+name);
		//看不出调用哪个实现类的方法体
		System.out.println(this.com.SaveComps(name));
		return 1;
	}

	public static void main(String[] args) {
		//启动ioc容器
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");       
		
		//2步操作ioc容器已经涵盖了
//		Class cla=Class.forName(add);
//    	Object ojb=cla.getDeclaredConstructor().newInstance();
//    	user=(IUsers) ojb;
//		<bean id="users" class="com.spring.model.UserImpl"></bean>
		 //获取bean id return OBject 对象
		IUser user=(IUser)ac.getBean("users");
		System.out.println(user.SaveUsers("aaa"));
	}

}
