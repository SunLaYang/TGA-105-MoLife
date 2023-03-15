 package com.tibame.tga105.admin.service;

import java.util.List;
import java.util.Objects;

import com.tibame.tga105.admin.AdminJDBCDAO;
import com.tibame.tga105.admin.VO.AdminVO;
import com.tibame.tga105.admin.dao.AdminDAOInterface;
import com.tibame.tga105.admin.dao.impl.AdminDaoImpl;

public class AdminService {
	 AdminDAOInterface dao;
	
	public AdminService() {
		dao = new AdminJDBCDAO();
//		dao = new AdminDaoImpl();
	}
	
//	public AdminVO addAdmin(AdminVO ) {
//		
//		AdminVO adminVO = new AdminVO();
//		adminVO.setEmpAcc(empAcc);
//		adminVO.setEmpPsd(empPsd);
//		adminVO.setEmpName(empName);
//		adminVO.setEmpPicId(empPicId);
//		adminVO.setEmpEmail(empEmail);
//		adminVO.setEmpAuthId(empAuthId);
//		adminVO.setEmpStatus(empStatus);
//		dao.insert(adminVO);		
//		
//		return adminVO;
//	}
	
	//預留給 Struts 2 或 Spring MVC 用
	public AdminVO addAdmin(AdminVO adminVO) {
		dao.insert(adminVO);
		return adminVO;
	}
	
	public AdminVO updateByEmp(AdminVO tempVO) {
		
		this.dao.empedit(tempVO);
		
		return tempVO;
	}
	
	//預留給 Struts 2 用的
//	public void updateByEmp(AdminVO tempVO) {
//		dao.empedit(tempVO);
//	}
	
	public AdminVO updateByBoss(AdminVO tempVO) {
		
		this.dao.bossedit(tempVO);
		return tempVO;
	}
	
	//預留給 Struts 2 用的
//	public void updateByBoss(AdminVO adminVO) {
//		dao.bossedit(adminVO);
//	}
	
	
	public void deleteEmp(Integer adminId) {
		dao.delete(adminId);
	}
	
	
	public AdminVO getOneEmp(Integer adminId) {
		return dao.findByPrimaryKey(adminId);
	}

	public AdminVO login(String empAcc, String empPsd) {
		if (!checkValue(empAcc) || !checkValue(empPsd)) {
			System.out.println("帳號或密碼錯誤");
			return null;
		}
		return dao.login(empAcc, empPsd);
		
	}
	
	private boolean checkValue(String value) {
		if (value == null || Objects.equals(value, "")) {
				System.out.println(value);
				return false;
		}
		return true;
	}
		
	public List<AdminVO> getAll(){
		return dao.getAll();
	}
	
}
