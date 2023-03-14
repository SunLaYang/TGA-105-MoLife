package com.tibame.tga105.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tibame.tga105.shop.domain.ProductOrder;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder, Integer> {
	List<ProductOrder> findByMemberId(Integer Id);
}
