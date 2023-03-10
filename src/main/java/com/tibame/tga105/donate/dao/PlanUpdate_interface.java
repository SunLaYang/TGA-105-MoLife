package com.tibame.tga105.donate.dao;

import java.util.List;

import com.tibame.tga105.donate.model.PlanUpdateVO;

public interface PlanUpdate_interface {
	
	//計畫詳情-List狀態更新 N_2_ongoingAndPay.jsp
	public List<PlanUpdateVO> getUpdateByPlanId(Integer planId);
	
	//會員中心-新增狀態更新 N_4-2_updateStatus.jsp
	public PlanUpdateVO insert(PlanUpdateVO planUpdateVO);
	
	//獲取動物圖片 N_2_ongoingAndPay.jsp
	public PlanUpdateVO getAnimalPhoto(Integer updateId);
	

}
