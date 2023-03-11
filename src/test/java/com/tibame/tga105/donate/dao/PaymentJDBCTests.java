package com.tibame.tga105.donate.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tibame.tga105.donate.model.PaymentVO;

@SpringBootTest
public class PaymentJDBCTests {
	@Autowired
	private PaymentDAO_interface dao;
	
	//memberId=null??
//	@Test
//	public void test() {
//		List<PaymentVO> list = dao.getMy(1);
//		System.out.println("list="+list);
//		System.out.println();
//	}
	
	@Test
	public void adminTest() {
		List<PaymentVO> adminList = dao.getAllPay();
		System.out.println("adminList="+adminList);
	}

}
