package com.tibame.tga105.donate.controller;

import java.io.IOException;
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


@WebServlet("/pages/donate/N_7_proposalSuccess")
public class ProposalSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private PlanService planService;
	
	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context = (ApplicationContext) application
				.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		this.planService = context.getBean("planService", PlanService.class);
	}
   
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PlanVO success = planService.successPage(1);
		req.setAttribute("result", success);
		req.getRequestDispatcher("/pages/donate/N_7_proposalSuccess.jsp").forward(req, res);
	
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
