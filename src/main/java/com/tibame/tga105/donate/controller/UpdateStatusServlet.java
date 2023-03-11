package com.tibame.tga105.donate.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import com.tibame.tga105.donate.model.PlanUpdateVO;
import com.tibame.tga105.donate.service.PlanUpdateService;

@WebServlet("/pages/donate/UpdateStatusServlet")
@MultipartConfig(maxFileSize = 300 * 1024, maxRequestSize = 300 * 1024 * 2)
public class UpdateStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PlanUpdateService planUpdateService;

	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context = (ApplicationContext) application
				.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		this.planUpdateService = context.getBean("planUpdateService", PlanUpdateService.class);
	}

	public static byte[] getPictureByteArray(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		return buffer;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
		doPost(request, res);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("errors", errors);

		// 1.要先儲存id
		String action = request.getParameter("memberAction");
		if ("saveId".equals(action)) {

			String str = request.getParameter("id");
			System.out.println("Parameter id=" + str);

			// 獲取session對象
			HttpSession session = request.getSession();
			// 儲存值到session中
			session.setAttribute("id", str);
			res.sendRedirect(request.getContextPath() + "/pages/donate/N_4-2_updateStatus.jsp");
		}

		// 2.表單更新
		if ("update".equals(action)) {

			// 1.取得參數
			// 1.1 planId
			HttpSession session = request.getSession();
			String strId = (String) session.getAttribute("id");
			Integer planId = Integer.valueOf(strId);
			System.out.println("planId = " + planId);

			// 1.2 date
			Date updateDate = java.sql.Date.valueOf(request.getParameter("updateDate"));
			String updateText = request.getParameter("updateText");

			// 1.3 updatePhoto
			byte[] animalPhoto = null;
			Part part = null;
			part = request.getPart("updatePhoto");

			if (part != null) {
				long fileSize = part.getSize();

				if (fileSize > 300 * 1024) {
					errors.put("animalPhoto", "照片大小不能超過300KB");
				} else {
					// 取得server Web應用程式的實際路徑
					String path = request.getServletContext()
							.getRealPath("/src/main/resources/static/css/donate/donate_pic");
					// 建立資料夾
					File folderPath = new File(path);
					if ((!folderPath.exists())) {
						folderPath.mkdirs();
					}

					// 取得上傳檔案的名稱
					String fileName = part.getSubmittedFileName();
					if (fileName != null && fileSize != 0) {
						String imgPath = folderPath + "/" + fileName;
						part.write(imgPath);
						animalPhoto = getPictureByteArray(imgPath);
						System.out.println("updatePhoto" + imgPath);
					} else {
						animalPhoto = Optional.ofNullable(animalPhoto).orElse(null);
					}

				}

			} else {
				animalPhoto = Optional.ofNullable(animalPhoto).orElse(null);
			}

			// 3.呼叫service新增資料
			PlanUpdateVO bean = new PlanUpdateVO();
			bean.setPlanId(planId);
			bean.setUpdateDate(updateDate);
			bean.setUpdateText(updateText);
			bean.setUpdatePhoto(animalPhoto);
			planUpdateService.addUpdate(bean);

			// 4.新增完成 redirect回會員中心-募款頁面
			System.out.println("新增完成");
			res.sendRedirect(request.getContextPath() + "/pages/donate/N_4-1_memberCenter");

		}
	}

}
