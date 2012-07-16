package com.ifunshow.antelopeframe.entity;

public class SystemLog {
	
	public SystemLog(){
		this.request_start_time = System.currentTimeMillis();
		this.excute_result_type="U";
	}
	
	public SystemLog(String id,String user_name,String user_real_name,String request_ip,String request_uri){
		this.id = id;
		this.user_name = user_name;
		this.user_real_name = user_real_name;
		this.request_ip = request_ip;
		this.request_uri = request_uri;
		this.request_start_time = System.currentTimeMillis();
		this.excute_result_type="U";
	}
	
	
	private String id;//'主键' 
	private String user_name;//'用户名' 
	private String user_real_name;//'姓名'
	private String request_ip;//'ip'
	private String request_uri;//'方法名'
	private Long request_start_time;//'请求开始时间'
	private Long request_end_time;//'请求结束时间'
	private String excute_result_type;//操作结果类型：U-未知；S-成功；F-失败
	private String excute_exception_msg;//'异常信息'
	
	
	public void setExcuteSuccess() {
		this.excute_result_type = "S";
	}
	
	public void setExcuteFailure() {
		this.excute_result_type = "F";
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_real_name() {
		return user_real_name;
	}
	public void setUser_real_name(String user_real_name) {
		this.user_real_name = user_real_name;
	}
	public String getRequest_ip() {
		return request_ip;
	}
	public void setRequest_ip(String request_ip) {
		this.request_ip = request_ip;
	}
	public String getRequest_uri() {
		return request_uri;
	}
	public void setRequest_uri(String request_uri) {
		this.request_uri = request_uri;
	}
	public Long getRequest_start_time() {
		return request_start_time;
	}
	public void setRequest_start_time(Long request_start_time) {
		this.request_start_time = request_start_time;
	}
	public Long getRequest_end_time() {
		return request_end_time;
	}
	public void setRequest_end_time(Long request_end_time) {
		this.request_end_time = request_end_time;
	}
	public String getExcute_result_type() {
		return excute_result_type;
	}
	public void setExcute_result_type(String excute_result_type) {
		this.excute_result_type = excute_result_type;
	}
	public String getExcute_exception_msg() {
		return excute_exception_msg;
	}
	public void setExcute_exception_msg(String excute_exception_msg) {
		this.excute_exception_msg = excute_exception_msg;
	}
}
