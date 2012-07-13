package com.ifunshow.antelopeframe.core.web.interceptor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CheckLoginInterceptor extends HandlerInterceptorAdapter {
	 
	private static final Logger logger = Logger.getLogger(ExecuteTimeInterceptor.class);
	
	private String sessionKey = "current_user";
	private String loginUri = "/login";
	private List excludeCheckUris = null;
	
	//before the actual handler will be executed
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)   throws Exception {
		String currentUri = request.getRequestURI().substring(request.getContextPath().length());
		boolean isMatch = false;
		if(null != excludeCheckUris && !excludeCheckUris.isEmpty()){
			for(Iterator _ite = excludeCheckUris.iterator();_ite.hasNext();){
				Pattern p = (Pattern)_ite.next();
				isMatch = p.matcher(currentUri).matches();
				if(isMatch){
					isMatch = true;
					break;
				}
			}
		}
		if (isMatch) {
			return true;
		}else{
			if(null == request.getSession().getAttribute(sessionKey)){
				response.sendRedirect(request.getContextPath()+loginUri);
				return false;
			}else{
				return true;
			}
		}
	}
 
	
	public String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}


	public List getExcludeCheckUris() {
		return excludeCheckUris;
	}

	public void setExcludeCheckUris(List excludeCheckUris) {
		if(null != excludeCheckUris && !excludeCheckUris.isEmpty()){
			if(null == this.excludeCheckUris){
				this.excludeCheckUris = new ArrayList();
			}
			for(Iterator _ite = excludeCheckUris.iterator();_ite.hasNext();){
				this.excludeCheckUris.add(Pattern.compile((String)_ite.next()));
			}
		}
	}


	public String getLoginUri() {
		return loginUri;
	}


	public void setLoginUri(String loginUri) {
		this.loginUri = loginUri;
	}
	
}
