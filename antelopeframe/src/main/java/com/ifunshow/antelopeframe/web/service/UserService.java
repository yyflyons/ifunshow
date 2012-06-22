package com.ifunshow.antelopeframe.web.service;

import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Service;
import com.ifunshow.antelopeframe.entity.User;

/**
 * 人员管理
 * @author Antelope-羚羊
 */
@Service
public class UserService extends BaseService{

	/**
	 * 根据条件查询
	 */
	public List queryResult(User user){
		return super.getMyBatisDao().getList("userMapper.selectByQuery",user);
	}
	
	public User getUser(Serializable id){
		return super.getMyBatisDao().get("userMapper.selectByPrimaryKey",id);
	}
}
