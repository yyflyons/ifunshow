package com.ifunshow.antelopeframe.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ifunshow.antelopeframe.core.extensions.exception.BusinessException;
import com.ifunshow.antelopeframe.core.extensions.exception.ParameterException;
import com.ifunshow.antelopeframe.entity.Role;
import com.ifunshow.antelopeframe.web.base.BaseController;
import com.ifunshow.antelopeframe.web.service.RoleService;

/**
 * 角色管理
 * @author Antelope-羚羊
 */
@Controller
@RequestMapping("/role")
public class RoleController  extends BaseController{

	@Autowired
	private RoleService roleService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model){
		model.addAttribute("list", roleService.getRoles());
		return "role/role_list";
	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	@ResponseBody
	public Model list2(Model model){
		model.addAttribute("list", roleService.getRoles());
		return model;
	}
	
	@RequestMapping(value="/new", method = RequestMethod.GET)
	public String create(Model model, Role role){
		model.addAttribute("entity",role);
		return "role/role_edit";
	}
	
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String edit(Model model, @PathVariable Integer id){
		model.addAttribute("entity", roleService.getRole(id));
		return "role/role_edit";
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(Model model, Role role){
		roleService.save(role);
		return "redirect:/role";
	}
	
	@RequestMapping(value="/view/{id}", method = RequestMethod.GET)
	public String view(Model model, @PathVariable Integer id){
		model.addAttribute("entity", roleService.getRole(id));
		return "role/role_view";
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String delete(Model model, @PathVariable Integer id){
		roleService.delete(id);
		return "redirect:/role";
	}
	
	/**
	 * 转到UserController
	 */
	@RequestMapping(value="/redirect_user", method = RequestMethod.GET)
	public String redirectUser(){
		return "redirect:/user";
	}
}
