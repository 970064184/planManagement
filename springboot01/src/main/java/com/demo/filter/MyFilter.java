package com.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class MyFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httprequest = (HttpServletRequest) request;
		// 防止流读取一次后就没有了, 所以需要将流继续写出去
	    ServletRequest requestWrapper = new BodyReaderHttpServletRequestWrapper(httprequest);
	    String json = HttpHelper.getBodyString(requestWrapper);
	    System.out.println("json参数：" + json);
	    System.out.println("url参数：" + httprequest.getQueryString());
	    chain.doFilter(requestWrapper, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	

}
