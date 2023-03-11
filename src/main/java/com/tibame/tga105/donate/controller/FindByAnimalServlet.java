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
import com.tibame.tga105.donate.service.AnimalTypeService;

@WebServlet("/pages/donate/FindByAnimalServlet")
public class FindByAnimalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AnimalTypeService animalTypeService;
	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context = (ApplicationContext) application.getAttribute(
				WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		this.animalTypeService = context.getBean("animalTypeService", AnimalTypeService.class);
	}
	

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		// 1.
		String str = req.getParameter("animalTypeId");
		Integer animalTypeId = 0;
		if (str != null && !str.isEmpty()) {
		    animalTypeId = Integer.valueOf(str);
		}

		// 2.
		List<PlanVO> planVO = animalTypeService.getPlanByAnimalId(animalTypeId);

		// 3.
		req.setAttribute("results", planVO);
		req.getRequestDispatcher("/pages/donate/N_5_search.jsp").forward(req, res);

	}

}
