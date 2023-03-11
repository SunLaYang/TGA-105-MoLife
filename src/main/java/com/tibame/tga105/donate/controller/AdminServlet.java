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

import com.tibame.tga105.donate.model.PaymentVO;
import com.tibame.tga105.donate.model.PlanVO;
import com.tibame.tga105.donate.service.PlanStatusService;

@WebServlet("/pages/donate/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PlanStatusService planStatusService;
	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context = (ApplicationContext) application.getAttribute(
				WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		this.planStatusService = context.getBean("planStatusService", PlanStatusService.class);
	}
	

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("adminAction");
		System.out.println("收到action=" + action);

		if (action.equals("selectByPlan")) {

			// 1.
			String str = req.getParameter("planStatusId");
			Integer planStatusId = 0;
			if (str != null && !str.isEmpty()) {
				planStatusId = Integer.valueOf(str);
			}

			// 2.
			List<PlanVO> planVO = planStatusService.getPlanByStatusId(planStatusId);

			// 3.
			req.setAttribute("result", planVO);
			req.getRequestDispatcher("/pages/donate/donatePlanResultAdmin.jsp").forward(req, res);

		}

		
		//=============================================================================
		

		if (action.equals("selectByPay")) {

			// 1.
			String str = req.getParameter("planStatusId");
			Integer planStatusId = 0;
			if (str != null && !str.isEmpty()) {
				planStatusId = Integer.valueOf(str);
			}

			// 2.
			List<PaymentVO> paymentVO = planStatusService.getPayByStatusId(planStatusId);

			// 3.
			req.setAttribute("result", paymentVO);
			req.getRequestDispatcher("/pages/donate/donatePayResultAdmin.jsp").forward(req, res);

		}

	}

}
