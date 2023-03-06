package com.tibame.tga105.auth.dao;

import java.util.List;
import java.util.Set;

import com.tibame.tga105.admin.VO.AdminVO;
import com.tibame.tga105.auth.VO.AuthVO;

public interface AuthDAOInterface {
	public void insert(AuthVO authVO);
	public void update(AuthVO authVO);
	public void delete(Integer empAuthId);
	public AuthVO findByPrimaryKey(Integer empAuthId);
	public List<AuthVO> getAll();
//	查詢某部門的員工(一對多)回傳set
	public Set<AdminVO> getEmpsByAuthId(Integer empAuthId);
}
