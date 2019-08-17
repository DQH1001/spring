package com.java.reference;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.reference.Iusers;

public class UserImpl implements Iusers {
	
	public UserImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int SaveUsers(String name) {
		System.out.println("save user "+name);
		
		return 1;
	}

	

}
