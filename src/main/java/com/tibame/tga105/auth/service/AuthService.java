package com.tibame.tga105.auth.service;

import java.util.List;
import java.util.Set;

import com.tibame.tga105.admin.VO.AdminVO;
import com.tibame.tga105.auth.VO.AuthVO;
import com.tibame.tga105.auth.dao.AuthDAOInterface;
import com.tibame.tga105.auth.dao.impl.AuthDaoImpl;

public class AuthService {
	
	private AuthDAOInterface dao;
	
	public AuthService() {
//		dao = new AuthJDBCDAO();
		dao = new AuthDaoImpl();		
	}
	
	public List<AuthVO> getAll() {
		return dao.getAll();
	}
	
	public AuthVO getOneAuth(Integer empAuthId) {
		return dao.findByPrimaryKey(empAuthId);
	}
	
	public Set<AdminVO> getEmpsByAuthId(Integer empAuthId){
		return dao.getEmpsByAuthId(empAuthId);
	}
	
	public void deleteAuth(Integer empAuthId) {
		dao.delete(empAuthId);
	}
	
	
	
}
