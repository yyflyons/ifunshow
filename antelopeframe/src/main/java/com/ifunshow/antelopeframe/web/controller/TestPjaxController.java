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
import com.ifunshow.antelopeframe.web.base.BaseController;
import com.ifunshow.antelopeframe.web.service.UserService;

/**
 * 人员管理
 * 
 * @author Antelope-羚羊
 */
@Controller
@RequestMapping("/testPjax")
public class TestPjaxController  extends BaseController{

	@Autowired
	private UserService userService;

	@RequestMapping(value="pjax",method = { RequestMethod.GET, RequestMethod.POST })
	public String testException(Model model, User user) {
		return "pjax/index";
	}

}