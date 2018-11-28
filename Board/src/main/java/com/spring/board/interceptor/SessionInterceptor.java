package com.spring.board.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		
		String reqUrl = request.getRequestURL().toString();
		System.out.println("reqUrl : "+reqUrl);
		if(reqUrl.contains("/board/list")){
			return true;
		}else if(reqUrl.contains("/board/detail"))
			return true;
		if(session.getAttribute("userEmail") == null){
			response.sendRedirect("/user/loginForm");
			return false;
		}
		
		return true;
		
	}

	
}
