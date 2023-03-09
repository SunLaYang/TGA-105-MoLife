package com.tibame.tga105.shop.service;

import java.util.List;
import java.util.Optional;

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

//	public boolean insert(ProductDTO productDTO) {
//		if (productDTO != null) {
//			productDao.insert(productDTO.getProduct());
//
//			Integer id = productDTO.getProduct().getProductId();
//			List<ProductImageBean> productImages = productDTO.getProductImages();
//			productImages = productImages.stream().map((item) -> {
//				item.setProductId(id);
//				return item;
//			}).collect(Collectors.toList());
//
//			productImageDAO.insertBatch(productImages);
//
//			return true;
//		}
//		return false;
//	}
//
//	public boolean update(ProductDTO productDTO) {
//		if (productDTO != null) {
//			productDao.update(productDTO.getProduct());
//
//			productImageDAO.updateBatch(productDTO.getProductImages());
//
//			return true;
//		}
//		return false;
//	}

}
