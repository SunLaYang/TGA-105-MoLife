package com.tibame.tga105.donate.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tibame.tga105.donate.model.PlanUpdateVO;

@SpringBootTest
public class PlanUpdateServiceTests {
	@Autowired
	public PlanUpdateService planUpdateService;

	@Test
	public void test() {
		List<PlanUpdateVO> list = planUpdateService.getUpdateByPlanId(1);
		System.out.println("list="+list);
	}
}
