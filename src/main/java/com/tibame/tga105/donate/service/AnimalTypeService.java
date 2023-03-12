package com.tibame.tga105.donate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tibame.tga105.donate.dao.AnimalTypeDAO_interface;
import com.tibame.tga105.donate.dao.AnimalTypeJDBCDAO;
import com.tibame.tga105.donate.model.AnimalTypeVO;
import com.tibame.tga105.donate.model.PlanVO;

@Service
public class AnimalTypeService {
	@Autowired
	private AnimalTypeDAO_interface dao;

	public AnimalTypeService() {
		dao = new AnimalTypeJDBCDAO();
	}
	
	// N_5_search.jsp
	public List<PlanVO> getPlanByAnimalId(Integer animalTypeId) {
		return dao.getPlanByAnimalId(animalTypeId);
	}
	
	// 
	public AnimalTypeVO getOneAnimal(Integer animalTypeId) {
		return dao.findByPrimaryKey(animalTypeId);
	}

	
}
