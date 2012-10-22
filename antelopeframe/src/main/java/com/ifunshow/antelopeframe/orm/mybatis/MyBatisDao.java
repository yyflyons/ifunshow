package com.ifunshow.antelopeframe.orm.mybatis;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * AntelopeFramework
 * 
 * MyBatis的Dao基类
 * @author yyflyons
 */
public class MyBatisDao extends SqlSessionDaoSupport{
	
	public int add(String key, Object object) {
		return getSqlSession().insert(key, object);
	}
	
	public int update(String key, Object object) {
		return getSqlSession().update(key, object);
	}
	
	public int delete(String key, Serializable id) {
		return getSqlSession().delete(key, id);
	}

	public int delete(String key, Object object) {
		return getSqlSession().delete(key, object);
	}
	
	public <T> T queryForOne(String key, Object params) {
		return (T) getSqlSession().selectOne(key, params);
	}
	
	public <T> List<T> queryForList(String key) {
		return getSqlSession().selectList(key);
	}
	
	public <T> List<T> queryForList(String key, Object params) {
		return getSqlSession().selectList(key, params);
	}
	
	public Map queryForMap(String statement, Object parameter, String mapKey){
		return getSqlSession().selectMap(statement, parameter, mapKey);
	}
}
