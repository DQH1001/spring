package com.spring.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.model.*;
public class SpringFactory {

	public SpringFactory() {
		// TODO Auto-generated constructor stub
		
	}
     //����IUser�ӿڵĲ�ͬʵ����:����ģʽ��javaweb��Ŀ����Щ��ʵ�õģ�
	//����·�ɷ������У�
	public IUser GetUserImpl1(int number) {
//		if(1==number) {
//			return new UserImpl();
//		}else if(2==number) {
		System.out.println("����ģʽע�����:"+number);
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
		//��̬����ģʽ��һ��<bean>
        //<bean id="factory" class="com.spring.factory.SpringFactory"
        //factory-method="GetIUserObject"></bean>
        //�ñ�ǩ����ִͬ���ˣ�SpringFactory.GetIUserObject();��ioc��̬����new beanģʽ
        //��ǩ��������new bean�ģ�����ioc����������factory-method��ͬSpringFactory����static�÷���
        //��ͨ����ģʽ����new���������Ȼ��new����.������ͨ�Զ��巽��  ��������new <bean>
//      <bean id="factory" class="com.spring.factory.SpringFactory" ></bean>
//      <bean id="fact" factory-bean="factory" factory-method="GetUserImpl1"></bean>
        //factory-bean="factory" ioc new һ�� SpringFactory new����Ȼ��ö������GetUserImpl1
        IUser user=(IUser)ac.getBean("fact");
		user.SaveUsers("aa");
	}

}
