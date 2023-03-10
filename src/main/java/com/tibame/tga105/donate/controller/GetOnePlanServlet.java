package com.tibame.tga105.donate.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import com.tibame.tga105.donate.model.PaymentVO;
import com.tibame.tga105.donate.model.PlanUpdateVO;
import com.tibame.tga105.donate.model.PlanVO;
import com.tibame.tga105.donate.service.PaymentService;
import com.tibame.tga105.donate.service.PlanService;
import com.tibame.tga105.donate.service.PlanUpdateService;


@WebServlet("/pages/donate/OnePlan")
public class GetOnePlanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PlanService planService;
	private PlanUpdateService planUpdateService;
	private PaymentService paymentService;
	
	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context = (ApplicationContext) application.getAttribute(
				WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		this.planService = context.getBean("planService", PlanService.class);
		this.planUpdateService = context.getBean("planUpdateService", PlanUpdateService.class);
		this.paymentService = context.getBean("paymentService", PaymentService.class);
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		Map<String,String> errors = new HashMap<String,String>();
		request.setAttribute("errors", errors);

		//??????planId
		String temp = request.getParameter("planId");
		System.out.println("temp ="+temp);
		HttpSession session = request.getSession();
		session.setAttribute("planId", temp);
		System.out.println("session?????????planId"+temp);


		/* ============================================================================= */
		
		// 1.??????????????????
		String action1 = request.getParameter("planAction");
		if ("GetOnePlan".equals(action1)) {

			String str = request.getParameter("planId");
			System.out.println("Plan id=" + str);

			Integer id = 0;
			if (str != null && !str.isEmpty()) {
				id = Integer.valueOf(str);
			}

			List<PlanVO> list = planService.getOnePlan(id);
			request.setAttribute("results", list);
		}

		/* ============================================================================= */

		// 2.????????????
		String action2 = request.getParameter("updateAction");
		if ("GetUpdate".equals(action2)) {

			String str = request.getParameter("planId");
			System.out.println("Update Plan id=" + str);

			Integer id = 0;
			if (str != null && !str.isEmpty()) {
				id = Integer.valueOf(str);
			}

			List<PlanUpdateVO> vo = planUpdateService.getUpdateByPlanId(id);
			request.setAttribute("updateResult", vo);
			request.getRequestDispatcher("/pages/donate/N_2_ongoingAndPay.jsp").forward(request, response);

		}
		
		/* ============================================================================= */
		
		// 3.??????
		String action3 = request.getParameter("payAction");
		if ("pay".equals(action3)) {
			
			// 1.????????????	
			// 1.1 ??????planId
			String str = request.getParameter("planId");
			System.out.println("???????????????Plan id=" + str);

			Integer planId1 = 0;
			if (str != null && !str.isEmpty()) {
				planId1 = Integer.valueOf(str);
			}
			
			// 1.2 ??????amount
			Integer paymentAmount = null;
			String amount = request.getParameter("paymentAmount");
			if ( amount==null || amount.trim().length()==0 ) {
				errors.put("paymentAmount", "????????????");
			} else {
				try {
					paymentAmount = Integer.parseInt(amount.trim());
					if ( paymentAmount<1 ) {
						errors.put("paymentAmount", "???????????????0");
					}
				} catch (NumberFormatException e) {
					e.printStackTrace();
					errors.put("paymentAmount",  "???????????????");
				}
			}
			
			// 1.3 ??????paymentDate
			String timestampStr = request.getParameter("paymentDate");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Timestamp paymentDate = null;
			// ?????? paymentDate ?????? null??????????????? Timestamp
			if (timestampStr != null) {
			  try {
			    java.util.Date parsedDate = sdf.parse(timestampStr);
			    paymentDate = new java.sql.Timestamp(parsedDate.getTime());
			  } catch (ParseException e) {
			    e.printStackTrace();
			    System.out.println(e);
			  }
			}
			

			// 2.
			// if failure - forward the same page
			if (errors!=null && !errors.isEmpty()) {
				//????????????
				List<PlanVO> list = planService.getOnePlan(planId1);
				request.setAttribute("result", list);
				
				List<PlanUpdateVO> vo = planUpdateService.getUpdateByPlanId(planId1);
				request.setAttribute("updateResult", vo);			
				request.getRequestDispatcher("/pages/donate/N_2_ongoingAndPay.jsp").forward(request,response);
				return;
			} 
			
			// if success - calling service to add proposal and forward to index
			PaymentVO bean = new PaymentVO();
			//?? memeberId
			bean.setMemeberId(1);
			bean.setPlanId(planId1);
			bean.setPaymentDate(paymentDate);
			bean.setPaymentAmount(paymentAmount);
			paymentService.addPayment(bean);

			//???????????? ??????????????????
			System.out.println("????????????,getContextPath()=" + request.getContextPath());
			response.sendRedirect(request.getContextPath()+"/pages/donate/N_6_paySuccess");	
			
			
		}
		
	}
}