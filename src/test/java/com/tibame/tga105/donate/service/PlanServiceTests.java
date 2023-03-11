package com.tibame.tga105.donate.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tibame.tga105.donate.model.PlanVO;

@SpringBootTest
public class PlanServiceTests {
	@Autowired
	private PlanService planService;
	
	@Test
	public void test() {
		List<PlanVO> list = planService.getall();
		System.out.println("list = "+list);
	}

}
