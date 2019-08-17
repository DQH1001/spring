package com.spring.aop;
/**
 * 通知管理类，AOP切面类对象
 * 通知管理，是多种模式的
 * @author Administrator
 *
 
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
/**
 * @配置aop
 * @author Administrator
 *
 */
@Aspect
public class InterceptorAnn {
	
// 还是需要定义切面点，是一个方法
	@Pointcut("execution(* com.spring.aop.PersonBean.*(..))")
	public void andMethdo() {}
	@After(value = "andMethdo()")
	public void doAfter() {
		System.out.println("Spring  After Method---");		
	}
	@AfterReturning("andMethdo()")
	public void doAfterReturn() {
		System.out.println("Spring  doAfterReturn Method---");		
	}
	@AfterThrowing("andMethdo()")
	public void doThrowing() {
		System.out.println("Spring  ThrowException Method---");		
	}
	@Before("andMethdo()")
	public void doBefore() {
		System.out.println("Spring  Before Method---");		
	}
	//环绕通知方法最特殊，因为是非常类似于Struts2拦截器和动态代理模式的方法，
//	也就是调用方法的之前之后都会执行
	@Around("andMethdo()")
	public Object doAround(ProceedingJoinPoint pj) throws Throwable {
		System.out.println("Spring 环绕进入---");
		Object result=pj.proceed();// 非常类似于2拦截器的invoke();
		System.out.println("Spring 环绕退出---:"+result);
		return result;
	}
//	Spring 环绕进入---
//	Spring  Before Method---
//	get name 1
//	Spring  After Method---
//	Spring  doAfterReturn Method---
//	Spring 环绕退出---:jack
//	jack
	/*
	 * <bean id="person" class="com.spring.aop.PersonBean">
</bean>

<bean id="aop1" class="com.spring.aop.InterceptorXML">
</bean>
<!-- 定义切面 -->
<aop:config>
  <!-- 切面类注入 -->
  <aop:aspect id="asp" ref="aop1">
     <!-- 配置切面拦截的类对象,pointcut定义切面点
     execution 定义的切面类，多个对象   java.lang.Integer,-->
     <aop:pointcut id="myCut" 
        expression="execution(!void com.spring.aop.PersonBean.*(..))" />
     <!-- 切面拦截的方法都是围绕该切面点操作的
           定义各个围绕拦截的方法操作 -->
     <aop:after method="doAfter" pointcut-ref="myCut"/>
     <aop:after-returning method="doAfterReturn" pointcut-ref="myCut"/>
     <aop:after-throwing method="doThrowing" pointcut-ref="myCut"/>
     <aop:around method="doAround" pointcut-ref="myCut"/>
     <aop:before method="doBefore" pointcut-ref="myCut"/>
  </aop:aspect>
</aop:config>
	 */
}
