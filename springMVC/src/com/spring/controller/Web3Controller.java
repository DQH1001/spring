package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/web3")
public class Web3Controller{
	@RequestMapping(value="/met")
	public String LoginUsers(HttpServletRequest req, String usn ,String pwd) {
//		String usn=req.getParameter("usn");
//		String pwd=req.getParameter("pwd");
		System.out.println(usn+pwd);
		return "first";
	}
	//不用request接收那必须保证参数名与页面中的name一样，否则拿到空值
	//或者加个@RequestParam("usn")
	@RequestMapping(value="/met1")
	public String LoginUsers1(HttpServletRequest req, String username ,String password) {
//		String usn=req.getParameter("usn");
//		String pwd=req.getParameter("pwd");
		System.out.println(username+"-"+password);
		return "first";
	}
	//批量提交参数,同样，页面中name名得和User类中set后名字一样，
	//但是不管一不一样，都会返回一个User对象，只是内部没有值，结果打印null/null
	@RequestMapping(value="/met2")
	public String LoginUsers2(HttpServletRequest req, User user) {
//		String usn=req.getParameter("usn");
//		String pwd=req.getParameter("pwd");
		System.out.println(user.getUsername()+" / "+user.getPassword());
		return "first";
	}
	/*
	 * 
	 * 配置Jackson jar后， @ResponseBody就可以灵活和返回值答辩返回json数据了
	 * 
	 */
	@RequestMapping(value="/met3")
	@ResponseBody
	public List<String> LoginUsers3(HttpServletRequest req, User user) {
		System.out.println(user.getUsername()+" / "+user.getPassword());
		List<String> l=new ArrayList<String>();
		l.add("e4");
		l.add("e3");
		return l;
	}
	/*
	 * 传递的是contentType:"application/json;charset=UTF-8",
	 * 415：异步传输格式不匹配
	 * @RequestBody User user需要接纳的是json数据格式，而你传递的格式是
	 * {username:"username",password:"#pass"} 在页面中json，但是传递到服务端叫文本，text格式了
	 * 所以告知页面是json数据格式，
	 * 修改了传递格式的时候contentType，提示了
	 * 400：格式类型匹配。格式修改了，但是具体的参数还是text，
	 * 继续修改，参数的序列化JSON.stringify({username1:"username",password2:"#pass"})
	 * 
	 * 
	 * 测试中要么全加上，否则全不加，二者是有效果的，但是区别
	 * key=value&key2=value2无法传递复杂的数据，也就是如果是二进制文件上传springmvc的时候，
	 * 有可能是二进制以外的其他数据比如usn，age..无法或者value
	 */
	@RequestMapping(value="/met4")
	@ResponseBody
	public List<String> LoginUsers4(HttpServletRequest req,@RequestBody User user) {
		System.out.println(user.getUsername()+" / "+user.getPassword());
		List<String> l=new ArrayList<String>();
		l.add("e4");l.add("e5");
		return l;
	}
	/*
	 * 缓存机制，还是借助于servlet的session 服务端缓存，但是操作逻辑和步骤差异是很大的
	 * springmvc利用@ModelAttribute("infos")创建一个session缓存，可以是共享的一个缓存，
	 * Session的一种模式
	 * 获取缓存：参数ModelMap model
	 */
	@ModelAttribute("infos")
	public List<Integer> getPool(){
		List<Integer> ls=new ArrayList<Integer>();
		ls.add(213);
		ls.add(43);
		ls.add(513);
		return ls;
	}
	@RequestMapping(value="/met5")
	@ResponseBody
	public List<String> LoginUsers5(HttpServletRequest req,@RequestBody User user,
			ModelMap model){
		System.out.println(user.getUsername()+" / "+user.getPassword());
		List<Integer> lst=(List<Integer>) model.get("infos");
		for (Integer integer : lst) {
			System.out.println(integer+"  +");
		}
		List<String> l=new ArrayList<String>();
		l.add("e6");l.add("e5");
		return l;
	}
}
