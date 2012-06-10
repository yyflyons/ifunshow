package com.ifunshow.antelopeframe.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
