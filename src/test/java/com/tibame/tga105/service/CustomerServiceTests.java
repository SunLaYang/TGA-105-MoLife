package com.tibame.tga105.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tibame.tga105.domain.CustomerBean;

@SpringBootTest
public class CustomerServiceTests {
	@Autowired
	private CustomerService customerService;
	
	@Test
	public void test() {
		CustomerBean login = customerService.login("Alex", "A");
		System.out.println("login="+login);	
		
		boolean change = customerService.changePassword(
				"Ellen", "E", "EEE");
		System.out.println("change="+change);
	}
}
