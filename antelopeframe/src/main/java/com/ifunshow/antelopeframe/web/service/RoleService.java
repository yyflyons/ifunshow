package com.ifunshow.antelopeframe.web.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifunshow.antelopeframe.entity.Role;
import com.ifunshow.antelopeframe.orm.mybatis.MyBatisDao;

/**
 * 角色管理
 * @author Antelope-羚羊
 */
@Service
public class RoleService {

	@Autowired
	private MyBatisDao myBatisDao;
	
	public List<Role> getRoles(){
		return myBatisDao.getList("roleMapper.selectByEntity");
	}
	
	public Role getRole(Serializable id){
		return myBatisDao.get("roleMapper.selectByPrimaryKey",id);
	}
	
	public void save(Role role){
		if(role.getId() == null)
			myBatisDao.save("roleMapper.insert", role);
		else
			myBatisDao.update("roleMapper.update", role);
	}
	
	public void delete(Serializable id){
		myBatisDao.delete("roleMapper.delete", id);
	}
}
