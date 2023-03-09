package com.tibame.tga105.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tibame.tga105.shop.domain.Product;
import com.tibame.tga105.shop.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping
	public List<Product> selectAll() {
		return productService.selectAll();
	}

	@GetMapping("/{id}")
	public Product selectId(@PathVariable Integer id) {
		return productService.selectId(id);
	}

//	@PostMapping
//	public boolean insert(@RequestBody ProductDTO productDTO) {	
//		return productService.insert(productDTO);
//	}
//	
//	@PutMapping
//	public boolean update(@RequestBody ProductDTO productDTO) {
//		return productService.update(productDTO);
//	}
//	

}
