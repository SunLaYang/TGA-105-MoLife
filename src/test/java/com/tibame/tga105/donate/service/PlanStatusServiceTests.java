package com.tibame.tga105.donate.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tibame.tga105.donate.model.PaymentVO;
import com.tibame.tga105.donate.model.PlanVO;

@SpringBootTest
public class PlanStatusServiceTests {
	@Autowired
	private PlanStatusService planStatusService;
	
	@Test
	public void planTest() {
		 List<PlanVO> planList = planStatusService.getPlanByStatusId(3);
		 System.out.println("planList = "+planList);
	}
	
	@Test
	public void payTest() {
		List<PaymentVO> payList = planStatusService.getPayByStatusId(3);
		System.out.println("payList = "+payList);
	}
	
	

}
