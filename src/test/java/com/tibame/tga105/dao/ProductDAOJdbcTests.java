package com.tibame.tga105.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tibame.tga105.domain.ProductBean;

@SpringBootTest
public class ProductDAOJdbcTests {
	@Autowired
	private ProductDAO dao;
	@Test
	public void test() {
		List<ProductBean> beans = dao.select();
		System.out.println("bean="+beans);
	}
}
