package com.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class WebController implements Controller {

	public WebController() {
		// TODO Auto-generated constructor stub
	}
    //
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 
		String usn=req.getParameter("usn");
		String pwd=req.getParameter("pwd");
		System.out.println(usn+pwd+"aa");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("first");
		return mv;
	}

}
