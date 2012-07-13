package com.ifunshow.antelopeframe.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ifunshow.antelopeframe.core.web.SpringContextHolder;

/**
 * 欢迎页面
 * @author Antelope-羚羊
 */
@Controller
public class HomeController {

	@RequestMapping("/home")
	public String home(){
		return "home";
	}
	
	@RequestMapping("/home/springBean/{beanName}")
	@ResponseBody
	public Model queryBeanByName(Model model, @PathVariable String beanName){
		model.addAttribute(beanName, SpringContextHolder.getBean(beanName));
		return model;
	}
	
	
}
