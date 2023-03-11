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

import com.tibame.tga105.donate.model.PlanVO;
import com.tibame.tga105.donate.service.PlanService;


@WebServlet("/pages/donate/AnimalPhotoServlet")
public class AnimalPhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PlanService planService;
	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context = (ApplicationContext) application
				.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		this.planService = context.getBean("planService", PlanService.class);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("image/jpeg, image/jpg, image/png");
		Integer planId = Integer.parseInt(request.getParameter("planId"));
		System.out.println("圖片收到的planId="+planId);
		ServletOutputStream out = response.getOutputStream();

		PlanVO vo = planService.getAnimalPhoto(planId);
		response.getOutputStream().write(vo.getAnimalPhoto());
		out.close();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}

}
