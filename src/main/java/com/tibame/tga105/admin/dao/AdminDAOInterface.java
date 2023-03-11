package com.tibame.tga105.admin.dao;

import java.util.List;

import com.tibame.tga105.admin.VO.AdminVO;

public interface AdminDAOInterface {
	public void insert(AdminVO adminVO);
	public void empedit(AdminVO adminVO);
	public void bossedit(AdminVO adminVO);
	public void delete(Integer adminId);
	public AdminVO findByPrimaryKey(Integer adminId);
	public List<AdminVO> getAll();	
	public AdminVO login(String empAcc, String empPsd);

}
