package com.tibame.tga105.donate.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tibame.tga105.donate.dao.PlanJDBCDAO;
import com.tibame.tga105.donate.model.PlanVO;

@Service
public class PlanService {
	@Autowired
	private PlanJDBCDAO dao;

	public PlanService() {
		dao = new PlanJDBCDAO();
	}

	// 1.新增計畫
	public PlanVO addPlan(PlanVO bean) {

		PlanVO result = null;
		if (bean!=null) {
			result = dao.insert(bean);
		}
		return result;
	}

	// 2.List募款中計畫詳情 
	public List<PlanVO> getOnePlan(Integer planId) {
		return dao.getOnePlan(planId);
	}

	// 3.List會員自己的計畫紀錄
	public List<PlanVO> findBymemberId(Integer memberId) {
		return dao.findBymemberId(memberId);
	}

	// 4.首頁-計畫 (照片/名稱/原因)
	public List<PlanVO> getall() {
		return dao.getall();
	}

	// 5.後台-List所有會員計畫紀錄
	public List<PlanVO> getallForAdmin() {
		return dao.getallForAdmin();
	}

	// 6.後台-修改計畫進度/donate_end_date/plan_status_comment
	public PlanVO updatePlan(PlanVO bean) {
		
		PlanVO result = null;
		if (bean!=null) {
			result = dao.update(bean.getPlanStatusId(), bean.getDonateEndDate(), 
					bean.getPlanStatusComment(), bean.getPlanId());
		}
		return result;
	}
		
	
	// 7.後臺修改頁面-顯示計畫內容
	public PlanVO getOnePlanForAdmin(Integer planId) {
		return dao.getOnePlanForAdmin(planId);
	}
	
	
	//8.獲取動物圖片
	public PlanVO getAnimalPhoto(Integer planId) {
		return dao.getAnimalPhoto(planId);

	}
}
