package com.tibame.tga105.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tibame.tga105.domain.ProductBean;

@SpringBootTest
public class ProductServiceTests {
	@Autowired
	private ProductService productService;

	@Test
	public void test() {
		List<ProductBean> selects = productService.select(null);
		System.out.println("selects="+selects);
	}
}
