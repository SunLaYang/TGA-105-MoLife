package com.tibame.tga105.shop.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tibame.tga105.shop.domain.Product;
import com.tibame.tga105.shop.domain.ProductOrder;
import com.tibame.tga105.shop.domain.ProductOrderItem;

@SpringBootTest
public class ProductOrderRepositoryTest {
	@Autowired
	private ProductOrderRepository productOrderRepository;

//	@Test
	void testSaveProductOrder() {
		// 創建一個訂單對象
		ProductOrder productOrder = new ProductOrder();
		productOrder.setMemberId(1);
		productOrder.setOrderStatus(1);
		productOrder.setOrderReceiver("John Doe");
		productOrder.setOrderAddress("123 Main St");
		productOrder.setOrderMobile("123-456-7890");
		productOrder.setOrderMessage("測試訊息");

		// 創建一個訂單項目對象
		ProductOrderItem productOrderItem = new ProductOrderItem();
		Product product = new Product();
		product.setProductId(1);
		productOrderItem.setProduct(product); // 設置訂單項目的產品
		productOrderItem.setProductNumber(1);
		productOrderItem.setProductPrice(1000);

		// 將訂單項目添加到訂單中
		productOrder.addOrderItem(productOrderItem);

		// 將訂單保存到數據庫
		ProductOrder savedProductOrder = productOrderRepository.save(productOrder);

		// 斷言保存的訂單對象的ID不為空
		assertNotNull(savedProductOrder.getOrderId());

		// 斷言保存的訂單對象的訂單項目列表不為空
		assertFalse(savedProductOrder.getItems().isEmpty());

		// 斷言保存的訂單項目對象的ID不為空
		assertNotNull(savedProductOrder.getItems().get(0).getOrderItemId());
	}

//	@Test
	void testSelectProductOrder() {
		List<ProductOrder> productOrders = productOrderRepository.findByMemberId(1);
		assertNotNull(productOrders);
		System.out.println(productOrders);
	}
	
//	@Test
	void testDeleteProductOrder() {
		ProductOrder productOrder = new ProductOrder();
		productOrder.setOrderId(7);
		productOrderRepository.delete(productOrder);
	}
	
	@Test
	void testUpdateProductOrder() {
		Optional<ProductOrder> optional = productOrderRepository.findById(6);
		if (optional.isPresent()) {
			optional.get().setOrderStatus(2);
			System.out.println(optional.get());
		}
	}
}
