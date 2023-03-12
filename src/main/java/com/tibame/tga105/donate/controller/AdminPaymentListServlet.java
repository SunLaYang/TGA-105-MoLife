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
import com.tibame.tga105.donate.service.PaymentService;


@WebServlet("/pages/donate/donatePaymentAdmin")
public class AdminPaymentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PaymentService paymentService;
	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context = (ApplicationContext) application
				.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		this.paymentService = context.getBean("paymentService", PaymentService.class);
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		List<PaymentVO> payList = paymentService.getAllPay();
		System.out.println("payList="+payList);
		req.setAttribute("payList", payList);
		req.getRequestDispatcher("/pages/donate/donatePaymentAdmin.jsp").forward(req, res);

	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
       
  
}
