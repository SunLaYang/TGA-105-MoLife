package com.tibame.tga105.donate.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tibame.tga105.donate.model.PaymentVO;
import com.tibame.tga105.donate.model.PlanVO;

@SpringBootTest
public class PlanStatusJDBCTests {
	@Autowired
	private PlanStatusDAO_interface dao;
	
	@Test
	public void planTest() {
		List<PlanVO> planList = dao.getPlanByStatusId(3);
		System.out.println("planList = "+planList);
	}
	
	@Test
	public void payTest() {
		List<PaymentVO> payList = dao.getPayByStatusId(3);
		System.out.println("payList = "+payList);
	}
	
}
