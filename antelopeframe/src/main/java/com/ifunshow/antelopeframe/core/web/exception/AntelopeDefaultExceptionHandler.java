package com.ifunshow.antelopeframe.core.web.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.ifunshow.antelopeframe.core.extensions.ajax.AjaxUtils;
import com.ifunshow.antelopeframe.core.extensions.exception.BusinessException;
import com.ifunshow.antelopeframe.core.extensions.exception.ParameterException;

public class AntelopeDefaultExceptionHandler implements
		HandlerExceptionResolver {

	private static final Logger logger = Logger.getLogger(AntelopeDefaultExceptionHandler.class);

	public ModelAndView resolveException(HttpServletRequest request,HttpServletResponse response, Object handler, Exception ex) {
		if (logger.isDebugEnabled()) {// 异常日志输出
			logger.debug(ex.getMessage());
		}
		if (AjaxUtils.isAjaxRequest(request)) {// Ajax请求
			PrintWriter out = null;
			try {
				response.setCharacterEncoding("utf-8");
				response.setContentType("application/json");
				out = response.getWriter();
				Map<String, Object> map = new HashMap();
				if (this.logger.isDebugEnabled()) {
					map.put("debug", true);
				}
				map.put("success", false);
				map.put("msg", "操作失败," + ex.getMessage());
				ObjectMapper objectMapper = new ObjectMapper();
				JsonGenerator jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(out);
				jsonGenerator.writeObject(map);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				out.flush();
				out.close();
			}
			return null;
		} else {// 非Ajax请求
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("ex", ex);
			// 根据不同错误转向不同页面
			if (ex instanceof BusinessException) {
				return new ModelAndView("error-business", model);
			} else if (ex instanceof ParameterException) {
				return new ModelAndView("error-parameter", model);
			} else {
				return new ModelAndView("error", model);
			}
		}
	}

}
