package com.ifunshow.antelopeframe.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ifunshow.antelopeframe.core.extensions.application.SpringContextHolder;
import com.ifunshow.antelopeframe.web.base.BaseController;

/**
 * 欢迎页面
 * @author Antelope-羚羊
 */
@Controller
@RequestMapping("/login")
public class LoginController  extends BaseController{
	
	@RequestMapping("/goLogin")
	public String goLogin(HttpServletRequest request){
		return "login";
	}

	@RequestMapping("/in")
	public String login(HttpServletRequest request){
		request.getSession().setAttribute("current_user", new Object());
		return "home";
	}
	
	@RequestMapping("/out")
	public String unlogin(HttpServletRequest request){
		request.getSession().removeAttribute("current_user");
		return "home";
	}
	
}
