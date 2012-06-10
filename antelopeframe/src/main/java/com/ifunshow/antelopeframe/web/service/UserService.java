package com.ifunshow.antelopeframe.web.service;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifunshow.antelopeframe.entity.User;
import com.ifunshow.antelopeframe.orm.mybatis.MyBatisDao;

/**
 * 人员管理
 * @author Antelope-羚羊
 */
@Service
public class UserService {

	@Autowired
	private MyBatisDao myBatisDao;
	
	/**
	 * 根据条件查询
	 */
	public List queryResult(User user){
		return myBatisDao.getList("userMapper.selectByQuery",user);
	}
	
	public User getUser(Serializable id){
		return myBatisDao.get("userMapper.selectByPrimaryKey",id);
	}
}
