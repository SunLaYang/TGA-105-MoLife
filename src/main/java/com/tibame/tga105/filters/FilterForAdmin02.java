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
//@WebFilter(urlPatterns = {"/pages/member/listAllMem.jsp",
//		"/pages/member/update_mem_by_admin.jsp",
//		"/pages/donate/donatePaymentAdmin.jsp",
//		"/pages/donate/donatePlanAdmin.jsp",
//		"/page/others/24admin.news.html",
//		"/page/others/24admin.forum.html",
//		"/page/others/24admin.chatroom.html",
//		"/pages/admin/addEmp.jsp",
//		"/pages/admin/listAllEmp.jsp",
//		"/pages/admin/boss_update.jsp"
//		}
//)
//public class FilterForAdmin02 implements Filter {
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
//    	if (!(tempVO.getEmpAuthId() == 3)) {
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
