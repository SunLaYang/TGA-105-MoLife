package com.tibame.tga105.mem.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.tibame.tga105.mem.model.MemService;
import com.tibame.tga105.mem.model.MemVO;



@WebServlet("/MemPicView")
public class MemPicView extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		req.setCharacterEncoding("UTF-8");
		res.setContentType("image/gif, image/jpg, image/jpeg, image/png");
		Integer memId = Integer.valueOf(req.getParameter("memId"));
		ServletOutputStream out = res.getOutputStream();

		MemService memSvc = new MemService();
		MemVO memVO = memSvc.getOneMem(memId);

		if (memVO.getMemPicId() != null) {
			out.write(memVO.getMemPicId());
			out.close();
		} else {
//			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			Resource resource = new ClassPathResource("\\static\\images\\defaultPicforIcon\\noImg.png");
			String defaultPicPath = resource.getFile().getPath();
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(defaultPicPath)));
			byte[] defaultPic = bis.readAllBytes();
			out.write(defaultPic);

			bis.close();

		}

//		PrintWriter out = res.getWriter();
//		out.print("123");
//		

	}

}
