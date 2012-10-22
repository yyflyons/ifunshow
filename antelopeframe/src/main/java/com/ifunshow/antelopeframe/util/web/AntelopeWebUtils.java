package com.ifunshow.antelopeframe.util.web;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.util.WebUtils;

/**
 * web工具类
 * @author yyflyons-于亚丰
 * 
 */
public class AntelopeWebUtils extends WebUtils{
		
		/**
		 * 获取IP地址
		 * @param request
		 * @return
		 */
		public static String getIpAddrByRequest(HttpServletRequest request) {  
	        String ip = request.getHeader("x-forwarded-for");  
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	            ip = request.getHeader("Proxy-Client-IP");  
	        }
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	            ip = request.getHeader("WL-Proxy-Client-IP");  
	        }
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	            ip = request.getRemoteAddr();  
	        }
	        return ip;  
		}
		
		/**
		 * 获取ip对应值
		 * @param ip
		 * @return
		 */
		public static double ip2num(String ip){
			double rtnIpnum = 0.0d;
			ip = StringUtils.trimToNull(ip);
			if(StringUtils.isNotBlank(ip)){
				String[]  ipsec = ip.split("\\.");
				if(null != ipsec && ipsec.length == 4){
					int ip1 = Integer.parseInt(ipsec[0]);
					int ip2 = Integer.parseInt(ipsec[1]);
					int ip3 = Integer.parseInt(ipsec[2]);
					int ip4 = Integer.parseInt(ipsec[3]);
					rtnIpnum = ip1*Math.pow(256,3)+ip2*Math.pow(256,2)+ip3*256+ip4;
				}
			}
			return rtnIpnum;
		}
		
}
