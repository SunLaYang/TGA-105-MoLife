package com.tibame.tga105.donate.controller;

import java.io.IOException;
import java.sql.Date;

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

@WebServlet("/pages/donate/AdminUpdateServlet")
public class AdminUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PlanService planService;
	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context = (ApplicationContext) application.getAttribute(
				WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		this.planService = context.getBean("planService", PlanService.class);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		// 測試planId
//		String temp = request.getParameter("id");
//		System.out.println("temp =" + temp);
//		HttpSession session = request.getSession();
//		session.setAttribute("planId", temp);
//		System.out.println("session收到的planId" + temp);

		// action解讀
		String action = request.getParameter("adminAction");

		/* ============================================================ */

		// 呈現admin修改的頁面
		if ("confirmPlan".equals(action)) {

			// 1.測試收到的id字串
			String str = request.getParameter("id");
			System.out.println("Plan id=" + str);

			// 2.轉Integer
			Integer id = 0;
			if (str != null && !str.isEmpty()) {
				id = Integer.valueOf(str);

			// 3.選取service()並forward呈現資料
			PlanVO planVO = planService.getOnePlanForAdmin(id);
			request.setAttribute("result", planVO);
			request.getRequestDispatcher("/pages/donate/donateUpdateAdmin.jsp").forward(request, response);

			}

		}

		/* ============================================================ */

		if ("updateAdmin".equals(action)) {

			// 1.測試收到的id字串為何
			String str = request.getParameter("id");
			System.out.println("Plan id=" + str);

			// 2.接收資料轉成java型別
			Integer planId = Integer.valueOf(request.getParameter("id"));
			Integer planStatusId = Integer.valueOf(request.getParameter("planStatusId"));

			// optional-donateEndDate 將donateEndDate的宣告放在if之外
			String strDate = request.getParameter("donateEndDate");
			Date donateEndDate = null;
			if (strDate != null && !strDate.isEmpty()) {
				donateEndDate = java.sql.Date.valueOf(strDate);
			}
			// optional-planStatusComment
			String planStatusComment = request.getParameter("planStatusComment");

			// 3.呼叫service()
			PlanVO bean = new PlanVO();
			bean.setPlanStatusId(planStatusId);
			bean.setDonateEndDate(donateEndDate);
			bean.setPlanStatusComment(planStatusComment);
			bean.setPlanId(planId);
			planService.updatePlan(bean);

			// 4.新增完成 redirect回donatePlanAdmin.jsp
			System.out.println("admin修改完成");
			response.sendRedirect(request.getContextPath()+"/pages/donate/donatePlanAdmin");

		}

	}

}
