package com.tibame.tga105.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Null;

import com.tibame.tga105.admin.VO.AdminVO;

@WebFilter(urlPatterns = {"/pages/admin/emp_update.jsp",
		"/pages/admin/listOneEmp.jsp",
		"/page/others/24admin.index.html"
		}
)
public class FilterForAdmin01 implements Filter {
	
	private FilterConfig config;
 
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
    		throws IOException, ServletException {
    	HttpServletRequest req = (HttpServletRequest) request;
    	
    	HttpServletResponse res = (HttpServletResponse) response;
    	
    	HttpSession session = req.getSession();
    	
    	AdminVO tempVO = (AdminVO) session.getAttribute("adminVO");
    	
    	if (session.getAttribute("adminVO") == null) {
    	 
   		res.sendRedirect("/pages/admin/loginEmp.jsp");
    		
    	}
    	else {
    		chain.doFilter(request, response);
		}
    	
    }

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config = config;
	}
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
		config = null;
		
	}

}
