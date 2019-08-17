package com.spring.aopTest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class interceptorAnn {
	//还是需要定义切面点，不过是一个方法
	@Pointcut("execution(* com.spring.aopTest.aa.*(..))")
	public void cut() {}
	@After(value="cut()")
	public void doAfter() {
		System.out.println("XML After Method");
	}
	@AfterReturning("cut()")
	public void doAfterReturn() {
		System.out.println("XML doAfterReturn Method");
	}
	@Before("cut()")
	public void doBefore() {
		System.out.println("XML doBefore Method");
	}
	@Around("cut()")
	public Object doAround(ProceedingJoinPoint pj) throws Throwable {
		System.out.println("XML 环绕进入------");
		Object result=pj.proceed();//非常类似于struts2拦截器的invoke()
		System.out.println("XML 环绕退出------"+result);
		return result;
	}
}
