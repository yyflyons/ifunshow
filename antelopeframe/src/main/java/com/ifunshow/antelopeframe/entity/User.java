package com.ifunshow.antelopeframe.entity;

/**
 * 人员管理
 * @author yyflyons-于亚丰
 */
public class User {

	private Integer id; //主键
	private String username; //登录用户
	private String password; //登录密码
	private Integer role_id; //角色ID
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
