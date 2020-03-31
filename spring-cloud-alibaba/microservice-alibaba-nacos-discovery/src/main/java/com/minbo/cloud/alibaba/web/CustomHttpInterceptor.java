package com.minbo.cloud.alibaba.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

/**
 * 拦截处理类
 * 
 * @author Minbo
 */
@Component
@Slf4j
@RefreshScope
public class CustomHttpInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		long start = System.currentTimeMillis();
		String url = request.getRequestURL().toString();
		String method = request.getMethod();
		String queryString = "";
		// 去掉最后一个空格
		Map<String, String[]> params = request.getParameterMap();
		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				String value = values[i];
				queryString += key + "=" + value + "&";
			}
		}
		// URL 参数
		queryString = queryString.equals("") ? null : queryString.substring(0, queryString.length() - 1);

		long end = System.currentTimeMillis();

		log.info(String.format("请求参数, url: %s, method: %s, query-params: %s, run-time: %s", url, method, queryString,
				(end - start) + ""));

		return true;
	}

}