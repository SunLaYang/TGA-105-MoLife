package com.tibame.tga105.donate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tibame.tga105.donate.dao.PlanStatusDAO_interface;
import com.tibame.tga105.donate.dao.PlanStatusJDBCDAO;
import com.tibame.tga105.donate.model.PaymentVO;
import com.tibame.tga105.donate.model.PlanStatusVO;
import com.tibame.tga105.donate.model.PlanVO;

@Service
public class PlanStatusService {
	@Autowired
	private PlanStatusDAO_interface dao;
	
	public PlanStatusService() {
		dao = new PlanStatusJDBCDAO();
	}
	
    public List<PlanVO> getPlanByStatusId(Integer planStatusId){
    	return dao.getPlanByStatusId(planStatusId);
    }
    
    public List<PaymentVO> getPayByStatusId(Integer planStatusId){
    	return dao.getPayByStatusId(planStatusId);
    }
    
	public PlanStatusVO getOneStatus(Integer planStatusId){
		return dao.findByPrimaryKey(planStatusId);
	}	
	
}
