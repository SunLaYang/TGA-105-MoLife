package com.tibame.tga105.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/pages/member/listOneMem.jsp",
		"/pages/member/update_mem_input.jsp",
		}
)
public class FilterForMember implements Filter {
	
	private FilterConfig config;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();

		if (session.getAttribute("memVO") == null) {
			res.sendRedirect("/pages/member/loginMem.jsp");
		} else {
			chain.doFilter(request, response);
			
		}

	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		
		this.config = config;
	}

	@Override
	public void destroy() {
		
		config = null;
	}

//	private FilterConfig config;
//	
//	public void init(FilterConfig config) throws ServletException {
//		this.config = config;
//	}
//
//	public void destroy() {
//		config = null;
//	}
//
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		HttpServletRequest req = (HttpServletRequest) request;
//		HttpServletResponse res = (HttpServletResponse) response;
//		HttpSession session = req.getSession();
//		System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
//
//		if (session.getAttribute("memVO") == null) {
//			System.out.println("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
//			res.sendRedirect("loginMem.jsp");
//		} else {
//			System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
//			chain.doFilter(request, response);
//			
//		}
//	}

}
