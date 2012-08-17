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
import org.springframework.ui.ModelMap;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import com.ifunshow.antelopeframe.core.extensions.ajax.AjaxUtils;
import com.ifunshow.antelopeframe.core.extensions.exception.BusinessException;
import com.ifunshow.antelopeframe.core.extensions.exception.ParameterException;

public class AntelopeDefaultExceptionHandler implements HandlerExceptionResolver {

	private static final Logger logger = Logger.getLogger(AntelopeDefaultExceptionHandler.class);

	public ModelAndView resolveException(HttpServletRequest request,HttpServletResponse response, Object handler, Exception ex) {
		if (logger.isDebugEnabled()) {// 异常日志输出
			logger.debug(ex.getMessage());
		}
		if (AjaxUtils.isAjaxRequest(request)) {//异步请求
			PrintWriter out = null;
			try {
				response.setCharacterEncoding("utf-8");
				response.setContentType("application/json");
				out = response.getWriter();
				ModelMap model = new ModelMap();
				if (this.logger.isDebugEnabled()) {
					model.addAttribute("debug", true);
				}
				model.addAttribute("success", false);
				model.addAttribute("msg", "操作失败," + ex.getMessage());
				ObjectMapper objectMapper = new ObjectMapper();
				JsonGenerator jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(out);
				jsonGenerator.writeObject(model);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				out.flush();
				out.close();
			}
			return null;
		} else {// 非异步请求
			ModelMap model = new ModelMap();
			model.addAttribute("ex", ex);
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
