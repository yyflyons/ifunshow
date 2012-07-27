package com.ifunshow.antelopeframe.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ifunshow.antelopeframe.core.extensions.exception.BusinessException;
import com.ifunshow.antelopeframe.core.extensions.exception.ParameterException;
import com.ifunshow.antelopeframe.entity.User;
import com.ifunshow.antelopeframe.web.service.UserService;

/**
 * 人员管理
 * 
 * @author Antelope-羚羊
 */
@Controller
@RequestMapping("/testException")
public class TestExceptionController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public String testException(Model model, User user) {
		model.addAttribute("list", userService.queryResult(user));
		model.addAttribute("entity", user);
		double a = 100/0;
		return "user/user_list";
	}
	
	@RequestMapping(value = "/testBusinessException",method = { RequestMethod.GET, RequestMethod.POST })
	public String testBusinessException(Model model, User user) {
		model.addAttribute("list", userService.queryResult(user));
		model.addAttribute("entity", user);
		throw new BusinessException("abc","--BusinessException--");
		//return "user/user_list";
	}

	@RequestMapping(value = "/testParameterException")
	public String testParameterException(@RequestParam String name) {
		throw new ParameterException("--ParameterException--");
	}
	
	@ResponseBody
	@RequestMapping(value = "/validatePara")
	public String validateName(@RequestParam String name) {
		throw new IllegalArgumentException("--IllegalArgumentException--");
	}

}