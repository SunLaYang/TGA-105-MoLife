package com.tibame.tga105.donate.dao;

import java.util.List;
import com.tibame.tga105.donate.model.PlanVO;

public interface PlanDAO_interface {
	
	// 1.新增計畫
	public PlanVO insert(PlanVO bean);
	
	// 2.List募款中計畫詳情 
	public List<PlanVO> getOnePlan(Integer planId);
	
	// 3.List會員自己的計畫紀錄
	public List<PlanVO> findBymemberId(Integer memberId);
	
	// 4.首頁-計畫 (照片/名稱/原因)
	public List<PlanVO> getall();
	
	// 5.後台-List所有會員計畫紀錄
	public List<PlanVO> getallForAdmin();
	
	// 6.後台-修改(計畫進度/donate_end_date/plan_status_comment)
	public PlanVO update(Integer planStatusId, java.util.Date donateEndDate, 
			String planStatusComment, Integer planId);
	
	// 7.後臺修改頁面-顯示計畫內容
	public PlanVO getOnePlanForAdmin(Integer planId);
	
	// 8.獲取動物圖片
	public PlanVO getAnimalPhoto(Integer planId);
	
	// 9.提案成功頁面
	public PlanVO successPage(Integer memberId);
	
}
