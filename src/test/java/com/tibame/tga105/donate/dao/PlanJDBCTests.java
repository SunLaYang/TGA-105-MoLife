package com.tibame.tga105.donate.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tibame.tga105.donate.model.PlanVO;

@SpringBootTest
public class PlanJDBCTests {
	@Autowired
	private PlanDAO_interface dao;
	
//	@Test
//	public void getOnePlanTest() {
//		PlanVO vo = dao.getOnePlan(1);
//		System.out.println("vo = "+vo);
//	}
	
//	@Test
//	public void memeberTest() {
//		List<PlanVO> list = dao.findBymemberId(1);
//		System.out.println("list="+list);
//	}

}
