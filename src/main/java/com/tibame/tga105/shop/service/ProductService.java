package com.tibame.tga105.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tibame.tga105.shop.domain.Product;
import com.tibame.tga105.shop.repository.ProductRepository;

@Service
@Transactional
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public List<Product> selectAll() {
		List<Product> products = productRepository.findAll();
		return products;
	}

	public Product selectId(Integer id) {
		if (id != null && !id.equals(0)) {
			return productRepository.findByProductId(id);
		}
		return null;
	}

	public boolean insert(Product product) {
		if (product != null) {
			product.getProductImages().forEach(productImage -> productImage.setProduct(product));
			productRepository.save(product);
			return true;
		}
		return false;
	}

	public boolean update(Product product) {
		if (product != null) {
			Product original = productRepository.findByProductId(product.getProductId());
			if (original != null) {
				product.getProductImages().forEach(productImage -> productImage.setProduct(product));
				productRepository.save(product);
				return true;
			}
		}
		return false;
	}

}