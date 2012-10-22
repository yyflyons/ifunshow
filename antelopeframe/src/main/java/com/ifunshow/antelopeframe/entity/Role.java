package com.ifunshow.antelopeframe.entity;

/**
 * 角色管理
 * @author yyflyons-于亚丰
 */
public class Role {

	private Integer id; //主键
	private String name; //角色名称
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
