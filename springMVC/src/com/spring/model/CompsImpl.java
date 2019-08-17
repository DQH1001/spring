package com.spring.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
@Component("coms")
public class CompsImpl implements IComps {
	
	public CompsImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int SaveComps(String name) {
		System.out.println("save comps user "+name);
		return 1;
	}

	

}
