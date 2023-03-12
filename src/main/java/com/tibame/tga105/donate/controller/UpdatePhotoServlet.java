package com.tibame.tga105.donate.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import com.tibame.tga105.donate.model.PlanUpdateVO;
import com.tibame.tga105.donate.service.PlanUpdateService;


@WebServlet("/pages/donate/UpdatePhotoServlet")
public class UpdatePhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PlanUpdateService planUpdateService;
	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context = (ApplicationContext) application.getAttribute(
				WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		this.planUpdateService = context.getBean("planUpdateService", PlanUpdateService.class);
	}
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("image/jpeg, image/jpg, image/png");
	
		Integer updateId= Integer.parseInt(request.getParameter("updateId"));
		ServletOutputStream out= response.getOutputStream();
		
		PlanUpdateVO vo = planUpdateService.getAnimalPhoto(updateId);
		response.getOutputStream().write(vo.getUpdatePhoto());
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
