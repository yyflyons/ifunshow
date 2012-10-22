package com.ifunshow.antelopeframe.web.service;

import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Service;
import com.ifunshow.antelopeframe.entity.User;
import com.ifunshow.antelopeframe.web.base.BaseService;

/**
 * 人员管理
 * @author yyflyons-于亚丰
 */
@Service
public class UserService extends BaseService{

	/**
	 * 根据条件查询
	 */
	public List queryResult(User user){
		return super.getMyBatisDao().queryForList("userMapper.selectByQuery",user);
	}
	
	public User getUser(Serializable id){
		return super.getMyBatisDao().queryForOne("userMapper.selectByPrimaryKey",id);
	}
}
