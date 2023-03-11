package com.tibame.tga105.donate.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import com.tibame.tga105.donate.model.PlanVO;
import com.tibame.tga105.donate.service.PlanService;


@WebServlet("/pages/donate/donatePlanAdmin")
public class AdminPlanListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private PlanService planService;
	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context = (ApplicationContext) application
				.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		this.planService = context.getBean("planService", PlanService.class);
	}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<PlanVO> list = planService.getallForAdmin();
		request.setAttribute("listAll", list);
		request.getRequestDispatcher("/pages/donate/donatePlanAdmin.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
