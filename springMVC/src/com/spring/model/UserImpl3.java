package com.spring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.java.reference.Iusers;
//value可以省略
@Component(value="us2")
//@Service(value="us2")
//@Repository(value="us2")
public class UserImpl3 implements IUser {
	//注解非常常用的方式,在Resources基础上完善的
	//@Autowired,IComps有多个实现类,找id与属性名相同的实现类注入
	//@Autowired
	//如果需要指定id名与属性名不一样的实现类,需加:@Qualifier("coms1")
	IComps coms=null;
	@Autowired
	public void setComs(@Qualifier("coms1")IComps com) {
//		<property name="coms" ref="com1"></property>
		System.out.println("setter注入1，依赖注入的第一种方式:"+com);
		
		this.coms = com;
	}
	@Override
	public int SaveUsers(String name) {
		System.out.println("save user1 "+name);
		//看不出调用哪个实现类的方法体
		//System.out.println(this.com.SaveComps(name));
		return 1;
	}
	public static void main(String[] args) {
		//启动ioc容器
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml"); 
		IUser user=(IUser)ac.getBean("us2");
		user.SaveUsers("aaa");
		IComps cm=(IComps)ac.getBean("coms");
		cm.SaveComps("bbb");
	}

	

}
