package com.bin.web.common.filter;
/**
 * 过滤器
 */
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bin.web.common.CodeEnum;
import com.bin.web.common.DtoUtils;
@WebFilter(filterName="LoginFilter",value={"/*"},
initParams={@WebInitParam(name="noLoginPaths",value="/api/pmsUser/v1/login;/api/pmsUser/v1/registPmsUser")})
public class LoginFilter implements Filter{
	
	private FilterConfig conf;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("过滤器初始化");
		conf=filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("过滤器过滤");
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		//设置不过滤的链接
		String noLoginPaths=conf.getInitParameter("noLoginPaths");
		if(!"".equals(noLoginPaths) && noLoginPaths!=null){
			String[] strArr=noLoginPaths.split(";");
			if(strArr!= null && strArr.length>0){
				for(int i=0;i<strArr.length;i++){
					if(req.getRequestURI().indexOf(strArr[i])!=-1){
						chain.doFilter(request, response);
						return;
					}
				}
			}
		}
		//判断用户是否登录
		HttpSession session = req.getSession();
		System.out.println(System.currentTimeMillis());
		System.out.println(session.getId()+"===="+session.getAttribute("userName"));
		/*if(session.getAttribute("userName")!=null){
			chain.doFilter(request, response);
			return;
		}else{
			System.out.println(DtoUtils.isError(CodeEnum.PSM_USER_NOTLOGIN));
			resp.sendRedirect("http://localhost:4200");
		}*/
		
		Cookie[] cookies = req.getCookies();
		if(cookies!= null && cookies.length> 0){
			for(int i= 0;i<cookies.length;i++){
				System.out.println(cookies[i].getName());
				if("userName".equals(cookies[i].getName())){
					chain.doFilter(request, response);
					return;
				}
			}
		}
		System.out.println(DtoUtils.isError(CodeEnum.PSM_USER_NOTLOGIN));
		resp.sendRedirect("http://localhost:4200");
	}

	@Override
	public void destroy() {
		System.out.println("过滤器销毁");
	}

}
