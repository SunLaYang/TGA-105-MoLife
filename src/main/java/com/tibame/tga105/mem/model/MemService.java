package com.tibame.tga105.mem.model;

import java.util.List;
import java.util.Objects;

import com.tibame.tga105.mem.dao.MemDAO_interface;

public class MemService {
//	private MemDAO_interface dao = (MemDAO_interface) new MemDAO();
	
	MemDAO_interface dao;
	
	public MemService() {
		dao = new MemJDBCDAO();
//		dao = new MemJNDIDAO();
		
	};

	public MemVO addMem(MemVO memVO) {	
		System.out.println("1"+memVO);
//		memVO.setMemStatus(1);
//		memVO.setPostSuspended(0);
//		memVO.setPostReportedNum(0);
		this.dao.insert(memVO);
		System.out.println("2"+memVO);
		return memVO;
	}

	public MemVO updateMem(MemVO tempVO) {
		this.dao.update(tempVO);
		return tempVO;
	}
	
	public MemVO updateMemByAdmin(MemVO tempVO) {
		this.dao.updateByAdmin(tempVO);
		return tempVO;
	}
	

	public void deleteMem(Integer memId) {
		this.dao.delete(memId);
	}

	public MemVO getOneMem(Integer memId) {
		return this.dao.findByPrimaryKey(memId);
	}
	
	public MemVO getMemFromEmail(String memEmail) {
		return this.dao.findByEmail(memEmail);
	}
	

	public List<MemVO> getAll() {
		return this.dao.getAll();
	}
	
	public MemVO login(String memEmail, String memPsd) {
		return dao.login(memEmail, memPsd);
	}
	
	
}
