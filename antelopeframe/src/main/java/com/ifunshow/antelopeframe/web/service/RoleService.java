package com.ifunshow.antelopeframe.web.service;

import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Service;
import com.ifunshow.antelopeframe.entity.Role;
import com.ifunshow.antelopeframe.web.base.BaseService;

/**
 * 角色管理
 * @author yyflyons-于亚丰
 */
@Service
public class RoleService extends BaseService{
	
	public List<Role> getRoles(){
		return super.getMyBatisDao().queryForList("roleMapper.selectByEntity");
	}
	
	public Role getRole(Serializable id){
		return super.getMyBatisDao().queryForOne("roleMapper.selectByPrimaryKey",id);
	}
	
	public void save(Role role){
		if(role.getId() == null)
			super.getMyBatisDao().add("roleMapper.insert", role);
		else
			super.getMyBatisDao().update("roleMapper.update", role);
	}
	
	public void delete(Serializable id){
		super.getMyBatisDao().delete("roleMapper.delete", id);
	}
}
