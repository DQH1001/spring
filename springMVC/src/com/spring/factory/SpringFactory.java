package com.spring.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.model.*;
public class SpringFactory {

	public SpringFactory() {
		// TODO Auto-generated constructor stub
		
	}
     //返回IUser接口的不同实现类:工厂模式，javaweb项目中有些不实用的，
	//用在路由服务器中，
	public IUser GetUserImpl1(int number) {
//		if(1==number) {
//			return new UserImpl();
//		}else if(2==number) {
		System.out.println("工厂模式注入参数:"+number);
			return new UserImpl1();
//		}else {
//			return null;
//		}
	}
	public static IUser GetIUserObject() {
		System.out.println("static method--");
//		if(1==number) {
			return new UserImpl();
//		}else if(2==number) {
//			return new UserImpl1();
//		}else {
//			return null;
//		}
	}
	public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");       
		//静态工厂模式：一个<bean>
        //<bean id="factory" class="com.spring.factory.SpringFactory"
        //factory-method="GetIUserObject"></bean>
        //该标签，如同执行了：SpringFactory.GetIUserObject();叫ioc静态工厂new bean模式
        //标签给工厂类new bean的，所以ioc容器启动，factory-method如同SpringFactory调用static该方法
        //普通工厂模式，先new工厂类对象，然后new对象.调用普通自定义方法  所以两个new <bean>
//      <bean id="factory" class="com.spring.factory.SpringFactory" ></bean>
//      <bean id="fact" factory-bean="factory" factory-method="GetUserImpl1"></bean>
        //factory-bean="factory" ioc new 一个 SpringFactory new对象，然后该对象调用GetUserImpl1
        IUser user=(IUser)ac.getBean("fact");
		user.SaveUsers("aa");
	}

}
