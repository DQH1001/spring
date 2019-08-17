package com.java.reference;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.java.reference.UserImpl;

/**
 * ��̬�����ӿ�ֻ�����һ��interface��"��Ͻ"��ʵ���࣬
 * ��һ�ǽӿھ�����ʵ����ĵ��ã��ڶ�����������ӿ������������ʵ�����ʱ�򣬸þ�̬����ģʽ
 * �ǳ��ķ����ˣ�����ԭ����new����Ϊnew��Ȼ������һ��������󷽷�������
 * ���ǻ���ֱ�����ӵĲ�������ģʽ
 * ���Բ���new������Ƶ��ù�ϵ
 * @author Administrator
 * �ĳɶද����ģʽ��ʵ��һ����̬��������ƵĽӿ�
 * ����java�����ķ��룬��̬�������İ���������������һ����java���������ڵİ�������Ϊ�漰
 * �ײ�jre����һ�����ʱ����Ҫ��һЩ���������Ҷ�̬����Ĳ���ģʽ��Щ����EJB��
 */
public class JD implements InvocationHandler{
	//��Ϊ��ͳһ�ӿڵ�Object����  IUsers us=(IUsers) use
    Object use;    
	public JD( Object user) {
		// TODO Auto-generated constructor stub
		use=user;
	}
    /**
     * Object retur=method.invoke(ojb, "okk");
     * @param proxy: ��ͬcla.getDeclaredConstructor().newInstance();����
     */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("����ǰ---");
//    	use.SaveUsers(name);   
		Object retur=method.invoke(use, args);
    	System.out.println("�����---");
		return retur;
	}
	/*
	 * Proxy.newProxyInstance:����һ��
	 * cla.getDeclaredConstructor().newInstance();����
	 * ���ǹ��̾��Ƕ�̬����ģʽInvocationHandler �� Proxy���ߺ����Ĳ����߼���
	 */
	public static void main(String[] args) {
		Iusers us=new UserImpl();
		InvocationHandler handler=new JD(us);
		//�����ģ�����ֱ�ӵ���invoke��
//		handler.invoke(proxy, method, args)
		//���Բ������Զ���Ľӿں�ʵ������Ҫͨ�����������ȡ
		us=(Iusers)Proxy.newProxyInstance(us.getClass().getClassLoader(),
				us.getClass().getInterfaces(),handler);
		System.out.println(us.SaveUsers("sfs"));
	}
}
