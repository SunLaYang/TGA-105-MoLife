package com.tibame.tga105.admin.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.tibame.tga105.admin.VO.AdminVO;
import com.tibame.tga105.admin.service.AdminService;

@WebServlet("/AdminPicView")
public class AdminPicView extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("image/gif, image/jpg, image/jpeg, image/png");
		
		Integer adminId = Integer.valueOf(req.getParameter("adminId"));
		
		ServletOutputStream out = res.getOutputStream();
		
		AdminService admSvc = new AdminService();
		AdminVO adminVO = admSvc.getOneEmp(adminId);
		
		
		if (adminVO.getEmpPicId() != null) {
			
			out.write(adminVO.getEmpPicId());
			out.close();
		}else {
			
//			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			Resource resource = new ClassPathResource("\\static\\images\\defaultPicforIcon\\noImg.png");
			String defaultPicPath = resource.getFile().getPath();
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(defaultPicPath)));
			byte[] defaultPic = bis.readAllBytes();
			out.write(defaultPic);

			bis.close();
		}
		
		
		
		
		
	}
	

}
