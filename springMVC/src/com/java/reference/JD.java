package com.java.reference;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.java.reference.UserImpl;

/**
 * 静态代理，接口只能针对一个interface所"管辖"的实现类，
 * 第一是接口局限于实现类的调用，第二如果有其他接口另外其他多个实现类的时候，该静态代理模式
 * 非常的繁琐了，归其原因还是new，因为new虽然可以有一个代理对象方法操作，
 * 但是还是直接连接的操作调用模式
 * 可以不用new反射机制调用关系
 * @author Administrator
 * 改成多动代理模式：实现一个动态代理反射机制的接口
 * （纯java基础的范畴，动态代理对象的案例，是最难理解的一个纯java基础范畴内的案例，因为涉及
 * 底层jre加载一个类的时候需要的一些参数。而且动态代理的操作模式有些类似EJB）
 */
public class JD implements InvocationHandler{
	//视为是统一接口的Object对象  IUsers us=(IUsers) use
    Object use;    
	public JD( Object user) {
		// TODO Auto-generated constructor stub
		use=user;
	}
    /**
     * Object retur=method.invoke(ojb, "okk");
     * @param proxy: 如同cla.getDeclaredConstructor().newInstance();对象
     */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("购买前---");
//    	use.SaveUsers(name);   
		Object retur=method.invoke(use, args);
    	System.out.println("购买后---");
		return retur;
	}
	/*
	 * Proxy.newProxyInstance:返回一个
	 * cla.getDeclaredConstructor().newInstance();对象
	 * 但是过程就是动态代理模式InvocationHandler 和 Proxy二者合作的操作逻辑了
	 */
	public static void main(String[] args) {
		Iusers us=new UserImpl();
		InvocationHandler handler=new JD(us);
		//繁琐的，不能直接调用invoke，
//		handler.invoke(proxy, method, args)
		//所以操作的自定义的接口和实现类需要通过反射操作获取
		us=(Iusers)Proxy.newProxyInstance(us.getClass().getClassLoader(),
				us.getClass().getInterfaces(),handler);
		System.out.println(us.SaveUsers("sfs"));
	}
}
