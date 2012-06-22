package com.ifunshow.antelopeframe.web.service;

import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Service;
import com.ifunshow.antelopeframe.entity.Role;

/**
 * 角色管理
 * @author Antelope-羚羊
 */
@Service
public class RoleService extends BaseService{
	
	public List<Role> getRoles(){
		return super.getMyBatisDao().getList("roleMapper.selectByEntity");
	}
	
	public Role getRole(Serializable id){
		return super.getMyBatisDao().get("roleMapper.selectByPrimaryKey",id);
	}
	
	public void save(Role role){
		if(role.getId() == null)
			super.getMyBatisDao().save("roleMapper.insert", role);
		else
			super.getMyBatisDao().update("roleMapper.update", role);
	}
	
	public void delete(Serializable id){
		super.getMyBatisDao().delete("roleMapper.delete", id);
	}
}
