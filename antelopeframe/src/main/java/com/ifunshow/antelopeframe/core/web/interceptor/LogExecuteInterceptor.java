package com.ifunshow.antelopeframe.core.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.UrlPathHelper;

import com.ifunshow.antelopeframe.entity.SystemLog;
import com.ifunshow.antelopeframe.util.uuid.UUIDHelper;
import com.ifunshow.antelopeframe.util.web.AntelopeWebUtils;
 
public class LogExecuteInterceptor extends HandlerInterceptorAdapter{
 
	private static final Logger logger = Logger.getLogger(LogExecuteInterceptor.class);
	
	UrlPathHelper uph = new UrlPathHelper();
	
	//before the actual handler will be executed
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		
		SystemLog systemLog = new SystemLog(UUIDHelper.UUIDGenerator(),"user_name","user_real_name",AntelopeWebUtils.getIpAddrByRequest(request),uph.getRequestUri(request));
		request.setAttribute("systemLog", systemLog);
 
		return true;
	}
 
	//after the handler is executed
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
 
		SystemLog systemLog = (SystemLog)request.getAttribute("systemLog");
		systemLog.setRequest_end_time(System.currentTimeMillis());
		systemLog.setExcuteSuccess();
		//log it
		if(logger.isDebugEnabled()){
		   logger.debug("[" + handler + "-"+request.getRequestURI()+"] executeTime : " + (systemLog.getRequest_end_time()-systemLog.getRequest_start_time()) + "ms");
		}
	}
}
