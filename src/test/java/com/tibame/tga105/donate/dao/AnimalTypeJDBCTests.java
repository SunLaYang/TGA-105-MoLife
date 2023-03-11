package com.tibame.tga105.donate.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tibame.tga105.donate.model.PlanVO;

@SpringBootTest
public class AnimalTypeJDBCTests {
	@Autowired
	private AnimalTypeDAO_interface dao;
	@Test
	public void test() {
		List<PlanVO> list = dao.getPlanByAnimalId(1);
		System.out.println("list="+list);
	}
	
}


//public static void main(String[] args) {
//
//		AnimalTypeJDBCDAO dao = new AnimalTypeJDBCDAO();
//		AnimalTypeVO vo1 = dao.findByPrimaryKey(3);
//		System.out.println(vo1.getAnimalType() + ",");
//		System.out.println(vo1.getAnimalTypeId() + "");
//		System.out.println("---------------------");

//		List<PlanVO> list = dao.getPlanByAnimalId(3);
//		for (PlanVO plan : list) {
//			System.out.println(plan.getAnimalPhoto() + ",");
//			System.out.println(plan.getPlanName() + ",");
//			System.out.println(plan.getReason());
//			System.out.println("---------------------------");
//		}

//}