package com.tibame.tga105.donate.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import com.tibame.tga105.donate.model.PlanVO;
import com.tibame.tga105.donate.service.PlanService;

@WebServlet("/pages/donate/ProposalServlet")
@MultipartConfig(maxFileSize = 300*1024 , maxRequestSize = 300*1024*2)
public class ProposalServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private PlanService planService;
	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context = (ApplicationContext) application.getAttribute(
				WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		this.planService = context.getBean("planService", PlanService.class);
	}
	
	public static byte[] getPictureByteArray(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		return buffer;
		}

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		Map<String,String> errors = new HashMap<String,String>();
		req.setAttribute("errors", errors);
		

		// 1. get parameter and valid
		Date proposalDate = java.sql.Date.valueOf(req.getParameter("proposalDate"));	
		
		Integer animalTypeId = null;
		String animalId = req.getParameter("animalTypeId");
		if ( animalId == null ) {
			errors.put("animalTypeId", "???????????????");
		} else {
			animalTypeId = Integer.parseInt(animalId);
		}
		
		String planName = req.getParameter("planName");
		String planNameReg = "^[(\\u4e00-\\u9fa5)(a-zA-Z0-9)]+$";
		if (planName == null || planName.trim().length() ==0) {
			errors.put("planName", "????????????");
		} else if ( !(planName.trim().matches(planNameReg)) ) {
			errors.put("planName", "????????????????????????????????????");
		}
		
		String address = req.getParameter("address");
		String addressReg = "^[(\\u4e00-\\u9fa5)(a-zA-Z0-9)]+$";
		if (address == null || address.trim().length() ==0) {
			errors.put("address", "????????????");
		} else if ( !(address.trim().matches(addressReg)) ) {
			errors.put("address", "????????????????????????????????????");
		}
		
		String reason = req.getParameter("reason");
		String reasonReg = "^[(\\u4e00-\\u9fa5)(a-zA-Z0-9)]+$";
		if (reason == null || reason.trim().length() ==0) {
			errors.put("reason", "????????????");
		} else if ( !(reason.trim().matches(reasonReg)) ) {
			errors.put("reason", "????????????????????????????????????");
		}
	
		Integer donateDays = null;
		String days = req.getParameter("donateDays");
		if ( days==null || days.trim().length()==0 ) {
			errors.put("donateDays", "????????????");
		} else {
			try {
				donateDays = Integer.parseInt(days.trim());
				if ( donateDays<1 || donateDays>100 ) {
					errors.put("donateDays", "???????????????1-100");
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errors.put("donateDays",  "???????????????");
			}
		}
		
		
		Integer donateGoal = null;
		String goal = req.getParameter("donateGoal");
		if ( goal==null || goal.trim().length()==0 ) {
			errors.put("donateGoal", "????????????");
		} else {
			try {
				donateGoal = Integer.parseInt(goal.trim());
				if (donateGoal<100 || donateGoal>100000) {
					errors.put("donateGoal", "???????????????$100-$100,000");
				}
			} catch(NumberFormatException e) {
				e.printStackTrace();
				errors.put("donateGoal",  "???????????????");
			}
			
		}
		
		String animalVideoLink = req.getParameter("animalVideoLink");
		String videoReg = "^https://www.youtube.com/.*" ;
		if ( !(animalVideoLink.matches(videoReg)) ) {
			errors.put("animalVideoLink", "?????????youtube??????");
		}
		
		
		//animalPhoto
		// ?????????????????????
		Part part = req.getPart("animalPhoto");
		long fileSize = part.getSize();
		
		if ( part ==null || fileSize==0 ) {
			errors.put("animalPhoto" ,"???????????????");
		} else if ( fileSize > 300*1024 ) {
			errors.put("animalPhoto" ,"????????????????????????300KB");
		}
		
		//??????server Web???????????????????????????
		String path = req.getServletContext().getRealPath("/src/main/resources/static/css/donate/donate_pic");
		//???????????????
		File folderPath = new File(path);
		if ( (!folderPath.exists()) ) {
			folderPath.mkdirs();
		}
		// ???????????????????????????
		String fileName = part.getSubmittedFileName();
		byte[] animalPhoto = null;
		if ( fileName!= null && fileSize!=0 ) {
			String imgPath = folderPath + "/" + fileName;
			part.write(imgPath);
			animalPhoto = getPictureByteArray(imgPath);
			System.out.println("animalPhoto"+imgPath);
		}
		
		
		/*---------------------------------------------------------------------------*/

		// if failure - forward the same page
		if (errors!=null && !errors.isEmpty()) {
			req.getRequestDispatcher("/pages/donate/N_3_proposal.jsp").forward(req,res);
			return;
		} 
		
		// if success - calling service to add proposal and forward to index
		Integer planStatusId = 1;
		//??memberId
		Integer memberId = 1;
		
		PlanVO bean = new PlanVO();
		bean.setProposalDate(proposalDate);
		bean.setPlanName(planName);
		bean.setAnimalTypeId(animalTypeId);
		bean.setAddress(address);
		bean.setReason(reason);
		bean.setDonateDays(donateDays);
		bean.setDonateGoal(donateGoal);
		bean.setAnimalVideoLink(animalVideoLink);
		bean.setAnimalPhoto(animalPhoto);
		bean.setPlanStatusId(planStatusId);
		bean.setMemberId(memberId);
		planService.addPlan(bean);	
		
		// ???????????? ??????????????????
		System.out.println("????????????");
		res.sendRedirect(req.getContextPath()+"/pages/donate/N_7_proposalSuccess");
		
	}
	

}
