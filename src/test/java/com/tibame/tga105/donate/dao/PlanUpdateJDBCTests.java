package com.tibame.tga105.donate.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tibame.tga105.donate.model.PlanUpdateVO;

@SpringBootTest
public class PlanUpdateJDBCTests {
	@Autowired
	private PlanUpdate_interface dao;
//	@Autowired
//	private PlanUpdateVO vo;
	
	@Test
	public void selectTest() {
		List<PlanUpdateVO> list = dao.getUpdateByPlanId(2);
		System.out.println("list = "+list);
	}
	
	//??跑不出結果
//	@Test
//	public void photoTest() {
//		PlanUpdateVO planUpdateVO = dao.getAnimalPhoto(1);
//		System.out.println("planUpdateVO = "+planUpdateVO);
//	}
	
	
	//??
//	@Test
//	public PlanUpdateVO insertTest() {
//		vo.setPlanId(3);
//		vo.setUpdateDate(java.sql.Date.valueOf("2023-03-09"));
//		vo.setUpdateText("03-09 test"); 
//		vo.setUpdatePhoto(null);
//		dao.insert(vo);
//		System.out.println("vo = "+vo);
//		return vo;
//	}

}



/*
 * public static void main(String[] args) {
 * 
 * PlanUpdateJDBCDAO dao = new PlanUpdateJDBCDAO();
 * 
 * // List<PlanUpdateVO> list = dao.getUpdateByPlanId(1); 
 * for (PlanUpdateVO update : list) { 
 * System.out.println(update.getUpdateDate() + ",");
 * System.out.println(update.getUpdateText() + ",");
 * System.out.println(update.getUpdatePhoto() + ",");
 * System.out.println(update.getUpdateVideoLink() + ","); }
 * 
 * 
 * // PlanUpdateVO vo = new PlanUpdateVO(); 
 * vo.setPlanId(2);
 * vo.setUpdateDate(java.sql.Date.valueOf("2023-02-23"));
 * vo.setUpdateText("test"); vo.setUpdatePhoto(null);
 * vo.setUpdateVideoLink("test"); dao.insert(vo);
 * 
 * }
 */

