package com.spring.aopTest;

import org.aspectj.lang.ProceedingJoinPoint;

public class interceptorXML {
	public void doAfter() {
		System.out.println("XML After Method");
	}
	public void doAfterReturn() {
		System.out.println("XML doAfterReturn Method");
	}
	public void doBefore() {
		System.out.println("XML doBefore Method");
	}
	public Object doAround(ProceedingJoinPoint pj) throws Throwable {
		System.out.println("XML 环绕进入------");
		Object result=pj.proceed();//非常类似于struts2拦截器的invoke()
		System.out.println("XML 环绕退出------"+result);
		return result;
	}
}
