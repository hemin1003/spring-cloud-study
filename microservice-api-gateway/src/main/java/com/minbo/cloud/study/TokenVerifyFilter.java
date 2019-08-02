package com.minbo.cloud.study;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * Token过滤验证
 * 
 * @author Minbo
 */
@Component
public class TokenVerifyFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		// 开启过滤验证
		return true;
	}

	/**
	 * 具体过滤逻辑，可以操作redis，或db，或其他验证权限等
	 */
	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		System.out.println(request.getMethod() + "，" + request.getRequestURL().toString());
		Object token = request.getParameter("token");
		if (token == null) {
			System.out.println("token is empty");
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			try {
				ctx.getResponse().getWriter().write("token is empty");
			} catch (Exception e) {
			}

			return null;
		}
		System.out.println("pass ok");
		return null;
	}

	/**
	 * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
	 * 1. pre：路由之前
	 * 2. routing：路由之时
	 * 3. post： 路由之后
	 * 4. error：发送错误调用
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}