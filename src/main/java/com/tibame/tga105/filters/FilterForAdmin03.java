//package com.tibame.tga105.filters;
//
//import java.io.IOException;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import javax.validation.constraints.Null;
//
//import com.tibame.tga105.admin.VO.AdminVO;
//
//@WebFilter(urlPatterns = {"/page/room/01RoomOrder.admin.html",
//		"/page/room/01Roommanage.admin.html"
//		}
//)
//public class FilterForAdmin03 implements Filter {
//	
//	private FilterConfig config;
// 
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
//    		throws IOException, ServletException {
//    	HttpServletRequest req = (HttpServletRequest) request;
//    	
//    	HttpServletResponse res = (HttpServletResponse) response;
//    	
//    	HttpSession session = req.getSession();
//    	
//    	AdminVO tempVO = (AdminVO) session.getAttribute("adminVO");
//    	
//    	if (session.getAttribute("adminVO") == null && (!(tempVO.getEmpAuthId() == 3) || !(tempVO.getEmpAuthId() == 2))) {
//    	 
//   		res.sendRedirect("/page/others/24admin.index.html");
//    		
//    	}
//    	else {
//    		chain.doFilter(request, response);
//		}
//    	
//    }
//
//	/**
//	 * @see Filter#init(FilterConfig)
//	 */
//	public void init(FilterConfig config) throws ServletException {
//		// TODO Auto-generated method stub
//		this.config = config;
//	}
//	/**
//	 * @see Filter#destroy()
//	 */
//	public void destroy() {
//		
//		config = null;
//		
//	}
//
//}
