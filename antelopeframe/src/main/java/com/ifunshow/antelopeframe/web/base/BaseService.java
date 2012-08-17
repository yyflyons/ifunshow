package com.ifunshow.antelopeframe.web.base;

import org.springframework.beans.factory.annotation.Autowired;
import com.ifunshow.antelopeframe.orm.mybatis.MyBatisDao;

/**
 * 基础service 所有业务Service都继承此类
 * @author Antelope-羚羊
 */

public class BaseService {

	@Autowired
	private MyBatisDao myBatisDao;

	public MyBatisDao getMyBatisDao() {
		return myBatisDao;
	}

	public void setMyBatisDao(MyBatisDao myBatisDao) {
		this.myBatisDao = myBatisDao;
	}
	
}
