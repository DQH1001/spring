package com.spring.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
@Component("coms1")
public class CompsImpl1 implements IComps {
	
	public CompsImpl1() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int SaveComps(String name) {
		System.out.println("save comps1 user "+name);
		return 1;
	}

	

}
