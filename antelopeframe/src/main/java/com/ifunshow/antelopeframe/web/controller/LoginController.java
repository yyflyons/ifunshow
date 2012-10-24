package com.ifunshow.antelopeframe.web.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ifunshow.antelopeframe.web.base.BaseController;

/**
 * 欢迎页面
 * @author yyflyons-于亚丰
 */
@Controller
@RequestMapping("/login")
public class LoginController  extends BaseController{
	
	@RequestMapping("/goLogin")
	public String pageLogin(HttpServletRequest request){
		return "pageLogin";
	}
	
	@RequestMapping("/popLogin")
	public String ajaxLogin(HttpServletRequest request){
		return "ajaxLogin";
	}

	@RequestMapping("/signin")
	public String login(HttpServletRequest request){
		request.getSession().setAttribute("current_user", new Object());
		return "home";
	}
	
	@RequestMapping("/signout")
	public String unlogin(HttpServletRequest request){
		request.getSession().removeAttribute("current_user");
		return "home";
	}
	
}
