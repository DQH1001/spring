package com.spring.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.reference.Iusers;

public class UserImpl1 implements IUser {
	IComps com=null;
	//name="coms"   ioc������ȡapp..�����ļ�����ע���̬���ø�setter������
//	ע�뵽com����Ϊ����ʵ��Ҫ���ã�Ҳ��������ע���com1����ķ���Objectʵ������
	public void setComs(IComps com) {
//		<property name="coms" ref="com1"></property>
		System.out.println("setterע��1������ע��ĵ�һ�ַ�ʽ:"+com);
		
		this.com = com;
	}

	public UserImpl1() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int SaveUsers(String name) {
		System.out.println("save user1 "+name);
		//�����������ĸ�ʵ����ķ�����
		System.out.println(this.com.SaveComps(name));
		return 1;
	}
	public static void main(String[] args) {
		//����ioc����
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml"); 
		IUser user=(IUser)ac.getBean("users1");
		System.out.println("�Զ�װ��");
		System.out.println(user.SaveUsers("aaa"));
	}

	

}
