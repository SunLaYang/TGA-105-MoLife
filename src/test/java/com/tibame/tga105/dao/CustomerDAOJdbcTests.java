package com.tibame.tga105.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tibame.tga105.domain.CustomerBean;

@SpringBootTest
public class CustomerDAOJdbcTests {
	@Autowired
	private CustomerDAO dao;
	
	@Test
	public void test() {
		CustomerBean bean = dao.select("Babe");
		System.out.println("bean="+bean);
		
		boolean result = dao.update("E".getBytes(),
				"ellen@lab.com", new java.util.Date(0), "Ellen");
		System.out.println("result="+result);
	}
}
