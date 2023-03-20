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
	
	public AdminVO getEmpFromAcc(String empAcc) {
		return this.dao.findByAcc(empAcc);
	}
	

	public AdminVO login(String empAcc, String empPsd) {
		return dao.login(empAcc, empPsd);
		
	}
		
	public List<AdminVO> getAll(){
		return dao.getAll();
	}
	
}
