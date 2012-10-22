package com.ifunshow.antelopeframe.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ifunshow.antelopeframe.entity.JavaBean;
import com.ifunshow.antelopeframe.web.base.BaseController;

/**
 * 人员管理
 * 
 * @author yyflyons-于亚丰
 */
@Controller
@RequestMapping("/testValidate")
public class TestValidateController  extends BaseController{

	@RequestMapping("/validate")
	public @ResponseBody String validate(@Validated JavaBean bean, BindingResult result) {
		if (result.hasErrors()) {
			return "Object has validation errors";
		} else {
			return "No errors";
		}
	}
}