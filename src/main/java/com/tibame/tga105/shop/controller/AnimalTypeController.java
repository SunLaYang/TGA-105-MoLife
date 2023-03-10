package com.tibame.tga105.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tibame.tga105.shop.domain.AnimalType;
import com.tibame.tga105.shop.service.AnimalTypeService;

@RestController
@RequestMapping("/animaltypes")
public class AnimalTypeController {
	@Autowired
	private AnimalTypeService animalTypeService;

	@GetMapping
	public List<AnimalType> selectAll() {
		return animalTypeService.selectAll();
	}
}
