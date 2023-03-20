package com.tibame.tga105.shop.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.tibame.tga105.shop.domain.Product;
import com.tibame.tga105.shop.domain.ProductCart;

@SpringBootTest
@Transactional
public class ProductCartRepositoryTests {

	@Autowired
	private ProductCartRepository productCartRepository;
	
//	@Test
	public void testFindById() {
		assertTrue(productCartRepository.findById(1).isPresent());
		assertFalse(productCartRepository.findById(999).isPresent());
		Integer qty = productCartRepository.findById(1).get().getProduct()
				.getProductQty();
		System.out.println(qty);
	}

//	@Test
	public void testFindAll() {

		List<ProductCart> productCarts = productCartRepository.findAll();
		if (!productCarts.isEmpty()) {
			System.out.println(productCarts);
		}
	}

//	@Test
	public void testFindByMemberIdAndProduct() {
		Product product = new Product();
		product.setProductId(1);
		ProductCart productCart = productCartRepository.findByMemberIdAndProduct(1, product);
		System.out.println(productCart.getProduct().getCategory());
	}

//	@Test
	public void testFindByMemberId() {
		List<ProductCart> productCarts = productCartRepository.findByMemberId(1);
		if (!productCarts.isEmpty()) {
			System.out.println(productCarts);
		}
	}
	
	@Commit
//	@Test
	public void testSave() {
		Product product = new Product();
		product.setProductId(4);
		ProductCart productCart = new ProductCart();
		productCart.setMemberId(1);
		productCart.setProduct(product);
		productCart.setProductNumber(5);
		
		productCart.setProductCartId(7);
		
		productCartRepository.save(productCart);
		
        assertNotNull(productCart.getProductCartId());
		System.out.println(productCart.getProductCartId());
	}
	
//	@Commit
//	@Test
	public void testDelete() {
		ProductCart productCart = new ProductCart();	
		productCart.setProductCartId(6);
		
		productCartRepository.delete(productCart);
		
		System.out.println(productCart.getProductCartId());
	}

}
