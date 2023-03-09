package com.tibame.tga105.shop.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.tibame.tga105.shop.domain.Product;
import com.tibame.tga105.shop.domain.ProductImage;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProductRepositoryTest {

	@Autowired
	private ProductRepository productRepository;

	@Test
	public void testSaveProductWithProductImage() {
		// 創建一個Product對象
		Product product = new Product();
		product.setProductName("測試商品");
		product.setProductDetails("測試商品詳情");
		product.setProductPrice(100);
		product.setProductQty(10);
		product.setProductStatus(1);
		product.setCategoryId(1);
		product.setAnimalTypeId(1);

		// 創建一個ProductImage對象
		ProductImage productImage = new ProductImage();
		productImage.setProductImageType(1);
		productImage.setProductImage("測試商品圖片");
		
		//將PproductImage添加到productImages列表中
		List<ProductImage> productImages = new ArrayList<>();
		productImages.add(productImage);
		
		// 為ProductImage對象設置Product對象
		productImage.setProduct(product);
		
		// 將PproductImages列表添加到Product
		product.setProductImages(productImages);


		
		// 調用ProductRepository.save()方法並驗證結果
		Product result = productRepository.save(product);
		assertNotNull(result);
		assertEquals("測試商品", result.getProductName());
		assertEquals(1, result.getProductImages().size());
		assertEquals("測試商品圖片", result.getProductImages().get(0).getProductImage());
	}
}
