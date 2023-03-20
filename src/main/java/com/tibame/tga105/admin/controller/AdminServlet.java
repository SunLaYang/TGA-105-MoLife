package com.tibame.tga105.admin.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tibame.tga105.admin.VO.AdminVO;
import com.tibame.tga105.admin.service.AdminService;

@WebServlet("/adminController")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
public class AdminServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		/*
		 * 查詢單一員工
		 */

		if ("getOne_For_Display".equals(action)) {

			List<String> erroMsgs = new LinkedList<String>();
			req.getSession().setAttribute("errorMsgs", erroMsgs);

//			1.接收請求參數
			String str = req.getParameter("adminId");

			if (str == null || (str.trim()).length() == 0) {
				erroMsgs.add("請輸入員工編號");

			}
			if (!erroMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/pages/admin/select_page.jsp");
				failureView.forward(req, res);
				return;
			}

			Integer adminId = null;
			try {
				adminId = Integer.valueOf(str);
			} catch (Exception e) {
				erroMsgs.add("員工編號格式不正確");
			}

			if (!erroMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/pages/admin/select_page.jsp");
				failureView.forward(req, res);
				return;
			}

			/******************************************************************************************/
			AdminService admSvc = new AdminService();
			AdminVO adminVO = admSvc.getOneEmp(adminId);
			if (adminVO == null) {
				erroMsgs.add("無此員工");
			}
			if (!erroMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("url//loging.jsp");
				failureView.forward(req, res);
				return;
			}

			req.setAttribute("adminVO", adminVO);
			String url = "/pages/admin/listOneEmp.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
		/******************************************************************************************/

		/*
		 * 員工要編輯自己的資料
		 */

		if ("emp_update".equals(action)) {// //來自ListOneMem.jsp的請求

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer adminId = Integer.valueOf(req.getParameter("adminId"));

			// 查詢
			AdminService admSvc = new AdminService();
			AdminVO adminVO = admSvc.getOneEmp(adminId);
			// 查詢完成，轉交

			req.setAttribute("adminVO", adminVO);
			String url = "/pages/admin/emp_update.jsp";
			res.sendRedirect(url);

		}

		/******************************************************************************************/
		

		/*
		 * 老闆要編輯員工資料
		 */

		
		if ("boss_Update".equals(action)) {// //來自listAllMem.jsp 或ListOneMem.jsp的請求

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer adminId = Integer.valueOf(req.getParameter("adminId"));

			// 查詢
			AdminService admSvc = new AdminService();
			AdminVO adminVO = admSvc.getOneEmp(adminId);
			// 查詢完成，轉交

			req.setAttribute("adminVO", adminVO);
			String url = "/pages/admin/boss_update.jsp";
			res.sendRedirect(url);
//			RequestDispatcher successView = req.getRequestDispatcher(url);
//			successView.forward(req, res);

		}

		/******************************************************************************************/
		

		/*
		 * 會員正在編輯自己的資料
		 */

		
		if ("updatebyEMP".equals(action)) {

			HttpSession session = req.getSession();
			
			List<String> errorMsgs = new LinkedList<String>();
			req.getSession().setAttribute("errorMsgs", errorMsgs);

			Integer adminId = Integer.valueOf(req.getParameter("adminId").trim());

			String empPsd = req.getParameter("empPsd");
			String empPsdReg = "^[(a-zA-Z0-9_)]{3,10}$";
			if (empPsd == null || empPsd.trim().length() == 0) {
				errorMsgs.add("員工密碼: 請勿空白");
			} else if (!empPsd.trim().matches(empPsdReg)) {
				errorMsgs.add("員工密碼請使用英文與數字之組合，長度介於3至10個字以內");
			}

			String empName = req.getParameter("empName");
			String empNameReg = "^[(\u4e00-\u9fa5)]{1,10}$";
			if (empName == null || empName.trim().length() == 0) {
				errorMsgs.add("員工名稱: 請勿空白");
			} else if (!empName.trim().matches(empNameReg)) {
				errorMsgs.add("員工名稱: 只能是中文字，且長度只能在1到10之間");
			}

			String empEmail = req.getParameter("empEmail");
			String empEmailReg = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
			if (empEmail == null || empEmail.trim().length() == 0) {
				errorMsgs.add("員工信箱: 請勿空白");
			} else if (!empEmail.trim().matches(empEmailReg)) {
				errorMsgs.add("員工信箱: 請符合電子信箱格式");
			}
			
			AdminVO tempVO = (AdminVO) session.getAttribute("adminVO");
			tempVO.setEmpPsd(empPsd);
			tempVO.setEmpName(empName);
			tempVO.setEmpEmail(empEmail);
			InputStream in = req.getPart("empPicId").getInputStream();
			byte[] empPicId = null;
			if (in.available() != 0) {
				empPicId = new byte[in.available()];
				in.read(empPicId);
				tempVO.setEmpPicId(empPicId);
				in.close();
			} 
//			tempVO.setAdminId(adminId);

			if (!errorMsgs.isEmpty()) {
				req.setAttribute("adminVO", tempVO);
				String url = "/pages/admin/emp_update.jsp";
//				RequestDispatcher failureView = req.getRequestDispatcher(url);
//				failureView.forward(req, res);
				res.sendRedirect(url);
				System.out.println(errorMsgs);
				return;
			}

			/*************************** 2.開始修改資料 *****************************************/
			AdminService admSvc = new AdminService();
			tempVO = admSvc.updateByEmp(tempVO);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("tempVO", tempVO);
			String url = "/pages/admin/listOneEmp.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url);
//			successView.forward(req, res);
			res.sendRedirect(url);

		}

		/******************************************************************************************/

		/*
		 * 老闆正在編輯自己的資料
		 */

		if ("updatebyBoss".equals(action)) {
			
			HttpSession session = req.getSession();

			List<String> errorMsgs = new LinkedList<String>();
			req.getSession().setAttribute("errorMsgs", errorMsgs);


			String empPsd = req.getParameter("empPsd");
			String empPsdReg = "^[(a-zA-Z0-9_)]{3,10}$";
			if (empPsd == null || empPsd.trim().length() == 0) {
				errorMsgs.add("會員密碼: 請勿空白");
			} else if (!empPsd.trim().matches(empPsdReg)) {
				errorMsgs.add("會員密碼請使用英文與數字之組合，長度介於3至10個字以內");
			}

			String empName = req.getParameter("empName");
			String empNameReg = "^[(\u4e00-\u9fa5)]{1,10}$";
			if (empName == null || empName.trim().length() == 0) {
				errorMsgs.add("員工暱稱: 請勿空白");
			} else if (!empName.trim().matches(empNameReg)) {
				errorMsgs.add("員工暱稱: 只能是中文字，且長度只能在1到10之間");
			}

			String empEmail = req.getParameter("empEmail");
			String empEmailReg = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
			if (empEmail == null || empEmail.trim().length() == 0) {
				errorMsgs.add("員工信箱: 請勿空白");
			} else if (!empEmail.trim().matches(empEmailReg)) {
				errorMsgs.add("員工信箱: 請符合電子信箱格式");
			}


			Integer empAuthId = Integer.valueOf(req.getParameter("empAuthId"));

			Integer empStatus = Integer.valueOf(req.getParameter("empStatus"));
			
			Integer adminId = Integer.valueOf(req.getParameter("adminId"));
			AdminService admSvc = new AdminService();
			AdminVO tempVO = admSvc.getOneEmp(adminId);

			tempVO.setEmpPsd(empPsd);
			
			tempVO.setEmpName(empName);
			
			InputStream in = req.getPart("empPicId").getInputStream();
			byte[] empPicId = null;
			if (in.available() != 0) {
				empPicId = new byte[in.available()];
				in.read(empPicId);
				tempVO.setEmpPicId(empPicId);
				in.close();
			} 
			tempVO.setEmpEmail(empEmail);
			tempVO.setEmpAuthId(empAuthId);
			tempVO.setEmpStatus(empStatus);
//			tempVO.setAdminId(adminId);

			if (!errorMsgs.isEmpty()) {
				req.setAttribute("adminVO", tempVO);
				String url = "/pages/admin/boss_update.jsp";
				res.sendRedirect(url);
				System.out.println(errorMsgs);
				return;
			}

			/*************************** 2.開始修改資料 *****************************************/
			tempVO = admSvc.updateByBoss(tempVO);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("adminVO", tempVO);
			String url = "/pages/admin/listAllEmp.jsp";
			res.sendRedirect(url);

		}

		/******************************************************************************************/
		

		/*
		 * 新增員工
		 */

		
		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			AdminService admSvc = new AdminService();
			
			req.getSession().setAttribute("errorMsgs", errorMsgs);

			String empAcc = req.getParameter("empAcc");
			String empAccReg = "^Emp[0-9]{3}$";
			if (empAcc == null || empAcc.trim().length() == 0) {
				errorMsgs.add("員工帳號 : 請勿空白");
			} else if (!empAcc.trim().matches(empAccReg)) {
				errorMsgs.add("員工帳號請使用Emp001~Emp999之間的組合");
			}
			if (admSvc.getEmpFromAcc(empAcc)!=null) {
				errorMsgs.add("此員工帳號已被註冊!");
			}

			String empPsd = req.getParameter("empPsd");
			String empPsdReg = "^[(a-zA-Z0-9_)]{3,10}$";
			if (empPsd == null || empPsd.trim().length() == 0) {
				errorMsgs.add("會員密碼: 請勿空白");
			} else if (!empPsd.trim().matches(empPsdReg)) {
				errorMsgs.add("會員密碼請使用英文與數字之組合，長度介於3至10個字以內");
			}

			String empName = req.getParameter("empName");
			String empNameReg = "^[(\u4e00-\u9fa5)]{1,10}$";
			if (empName == null || empName.trim().length() == 0) {
				errorMsgs.add("員工暱稱: 請勿空白");
			} else if (!empName.trim().matches(empNameReg)) {
				errorMsgs.add("員工暱稱: 只能是中文字，且長度只能在1到10之間");
			}

			String empEmail = req.getParameter("empEmail");
			String empEmailReg = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
			if (empEmail == null || empEmail.trim().length() == 0) {
				errorMsgs.add("員工信箱: 請勿空白");
			} else if (!empEmail.trim().matches(empEmailReg)) {
				errorMsgs.add("員工信箱: 請符合電子信箱格式");
			}
			
			Integer empAuthId = Integer.valueOf(req.getParameter("empAuthId"));

			Integer empStatus = Integer.valueOf(req.getParameter("empStatus"));
			
			AdminVO adminVO = new AdminVO();

			
			adminVO.setEmpAcc(empAcc);
			adminVO.setEmpPsd(empPsd);
			adminVO.setEmpName(empName);
			adminVO.setEmpEmail(empEmail);
			InputStream in = req.getPart("empPicId").getInputStream();
			byte[] empPicId = null;
			if (in.available() != 0) {
				empPicId = new byte[in.available()];
				in.read(empPicId);
				adminVO.setEmpPicId(empPicId);
				in.close();
			} 
			adminVO.setEmpAuthId(empAuthId);
			adminVO.setEmpStatus(empStatus);
			req.getSession().setAttribute("adminVO", adminVO);

			if (!errorMsgs.isEmpty()) {
				req.setAttribute("adminVO", adminVO);
				String url = "/pages/admin/addEmp.jsp";
//				RequestDispatcher failureView = req.getRequestDispatcher(url);
//				failureView.forward(req, res);
				System.out.println(errorMsgs);
				res.sendRedirect(url);
				return;
			}

			/*************************** 2.開始修改資料 *****************************************/
			
			adminVO = admSvc.addAdmin(adminVO);

			req.setAttribute("success", "新增會員成功");
			String url = "/pages/admin/listAllEmp.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url);
//			successView.forward(req, res);
			res.sendRedirect(url);
		}

		/******************************************************************************************/

		/*
		 * 刪除員工
		 */

		if ("delete".equals(action)) { // 來自listAllAdmin.jsp

			List<String> errorMsgs = new LinkedList<String>();

			req.getSession().setAttribute("errorMsgs", errorMsgs);

			Integer adminId = Integer.valueOf(req.getParameter("adminId"));

			AdminService admSvc = new AdminService();
			admSvc.deleteEmp(adminId);

			String url = "/pages/admin/listAllEmp.jsp";
			res.sendRedirect(url);
//			RequestDispatcher successView = req.getRequestDispatcher(url);
//			successView.forward(req, res);
		}
		
		/******************************************************************************************/
		

		/*
		 * 員工登入
		 */

		
		if ("login".equals(action)) {// 來自loginEmp.jsp

			List<String> erroMsgs = new LinkedList<String>();
			req.getSession().setAttribute("errorMsgs", erroMsgs);
			

//			1.接收請求參數
			String empacc = req.getParameter("empAcc");
			String emppsd = req.getParameter("empPsd");
			if (empacc == null || (empacc.trim()).length() == 0) {
				erroMsgs.add("請輸入員工帳號");
			}
			if (!erroMsgs.isEmpty()) {
				String url = "/pages/admin/loginEmp.jsp";
				res.sendRedirect(url);
				return;
			}
			if (emppsd == null || (emppsd.trim()).length() == 0) {
				erroMsgs.add("請輸入密碼");
			}
			if (!erroMsgs.isEmpty()) {
				String url = "/pages/admin/loginEmp.jsp";
				res.sendRedirect(url);
				return;
			}


			/******************************************************************************************/
			AdminService admSvc = new AdminService();
			AdminVO adminVO = new AdminVO();
			adminVO.setEmpAcc(empacc);
			adminVO.setEmpPsd(emppsd);
			adminVO = admSvc.login(empacc,emppsd);
			HttpSession session =req.getSession();
			
			if (adminVO == null) {
				erroMsgs.add("帳號或密碼錯誤");
			}
			if (!erroMsgs.isEmpty()) {
				String url = "/pages/admin/loginEmp.jsp";
				res.sendRedirect(url);
				return;
			}
			
			else {
				if (req.getSession(false) != null) {
					req.changeSessionId();// 產生新的sessionId
				}
				session.setAttribute("adminVO", adminVO);
				req.setAttribute("login", true);
			}
			
			req.setAttribute("adminVO", adminVO);
			String url = "/pages/admin/listOneEmp.jsp";
			res.sendRedirect(url);
		}
		
		/******************************************************************************************/
		/*
		 * 登出會員
		 */

		if ("logout".equals(action)) { // 來自listOneEmp.jsp
			
			HttpSession session = req.getSession();
			
			session.invalidate();

//				刪除完成，準備轉接
			String url = "/pages/admin/loginEmp.jsp";
			res.sendRedirect(url);
		}

		/******************************************************************************************/
		
	}

}
