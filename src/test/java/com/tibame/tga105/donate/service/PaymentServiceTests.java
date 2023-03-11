package com.tibame.tga105.donate.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tibame.tga105.donate.model.PaymentVO;

@SpringBootTest
public class PaymentServiceTests {

	@Autowired
	private PaymentService paymentService;
	
	@Test
	public void test() {
		List<PaymentVO> list = paymentService.getMy(1);
		System.out.println("list="+list);
	}
	
	@Test
	public void adminTest() {
		List<PaymentVO> adminList = paymentService.getAllPay();
		System.out.println("adminList="+adminList);
	}
	
	
}
