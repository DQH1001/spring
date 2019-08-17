package com.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/web2")
public class Web2Controller{

	public Web2Controller() {
		// 
	}

	@RequestMapping(value="/met")
	public String LoginUsers(HttpServletRequest req, HttpServletResponse resp) {
		String usn=req.getParameter("usn");
		String pwd=req.getParameter("pwd");
		System.out.println(usn+pwd);
		return "first";
	}
//	@Override
//	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
//		// 
//		
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("");
//		return mv;
//	}

}
