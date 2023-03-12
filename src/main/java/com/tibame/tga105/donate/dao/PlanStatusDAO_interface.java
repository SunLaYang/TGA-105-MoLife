package com.tibame.tga105.donate.dao;

import java.util.List;

import com.tibame.tga105.donate.model.PaymentVO;
import com.tibame.tga105.donate.model.PlanStatusVO;
import com.tibame.tga105.donate.model.PlanVO;

public interface PlanStatusDAO_interface {
	
	public PlanStatusVO findByPrimaryKey(Integer planStatusId);
	
	// admin-查詢某個進度狀態的計畫 donatePlanResultAdmin.jsp
    public List<PlanVO> getPlanByStatusId(Integer planStatusId);
    
    // admin-查詢某個進度狀態的捐款 donatePayResultAdmin.jsp
    public List<PaymentVO> getPayByStatusId(Integer planStatusId);
	

}
