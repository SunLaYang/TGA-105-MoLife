package com.tibame.tga105.donate.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tibame.tga105.donate.model.PlanVO;

@SpringBootTest
public class AnimalTypeServiceTests {
	@Autowired
	private AnimalTypeService animalTypeService;
	
	@Test
	public void test() {
		List<PlanVO> list = animalTypeService.getPlanByAnimalId(1);
		System.out.println("list="+list);
	}

}
