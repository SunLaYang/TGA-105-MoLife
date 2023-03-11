package com.tibame.tga105.donate.dao;

import java.util.List;

import com.tibame.tga105.donate.model.AnimalTypeVO;
import com.tibame.tga105.donate.model.PlanVO;

public interface AnimalTypeDAO_interface {

	public AnimalTypeVO findByPrimaryKey(Integer animalTypeId);
	  
	public List<PlanVO> getPlanByAnimalId(Integer animalTypeId);
}
