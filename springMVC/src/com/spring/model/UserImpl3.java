package com.spring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.java.reference.Iusers;
//value����ʡ��
@Component(value="us2")
//@Service(value="us2")
//@Repository(value="us2")
public class UserImpl3 implements IUser {
	//ע��ǳ����õķ�ʽ,��Resources���������Ƶ�
	//@Autowired,IComps�ж��ʵ����,��id����������ͬ��ʵ����ע��
	//@Autowired
	//�����Ҫָ��id������������һ����ʵ����,���:@Qualifier("coms1")
	IComps coms=null;
	@Autowired
	public void setComs(@Qualifier("coms1")IComps com) {
//		<property name="coms" ref="com1"></property>
		System.out.println("setterע��1������ע��ĵ�һ�ַ�ʽ:"+com);
		
		this.coms = com;
	}
	@Override
	public int SaveUsers(String name) {
		System.out.println("save user1 "+name);
		//�����������ĸ�ʵ����ķ�����
		//System.out.println(this.com.SaveComps(name));
		return 1;
	}
	public static void main(String[] args) {
		//����ioc����
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml"); 
		IUser user=(IUser)ac.getBean("us2");
		user.SaveUsers("aaa");
		IComps cm=(IComps)ac.getBean("coms");
		cm.SaveComps("bbb");
	}

	

}
