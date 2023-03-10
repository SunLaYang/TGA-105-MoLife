package com.tibame.tga105.donate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tibame.tga105.donate.dao.PlanUpdateJDBCDAO;
import com.tibame.tga105.donate.dao.PlanUpdate_interface;
import com.tibame.tga105.donate.model.PlanUpdateVO;

@Service
public class PlanUpdateService {

	@Autowired
	private PlanUpdate_interface dao;

	public PlanUpdateService() {
		dao = new PlanUpdateJDBCDAO();
	}

	// 計畫詳情-List狀態更新 N_2_ongoingAndPay.jsp
	public List<PlanUpdateVO> getUpdateByPlanId(Integer planId) {
		return dao.getUpdateByPlanId(planId);
	}

	// 會員中心-新增狀態更新 N_4-2_updateStatus.jsp
	public PlanUpdateVO addUpdate(PlanUpdateVO bean) {
		PlanUpdateVO result =null;
		if (bean!=null) {
			result = dao.insert(bean);
		}
		return result;
	}

	//獲取動物圖片 N_2_ongoingAndPay.jsp
	public PlanUpdateVO getAnimalPhoto(Integer updateId) {
		return dao.getAnimalPhoto(updateId);
	}

}
