package com.tibame.tga105.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.tibame.tga105.shop.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {
	@EntityGraph(value = "product.fk", type = EntityGraphType.LOAD)
	List<Product> findAll();

	@EntityGraph(value = "product.fk", type = EntityGraphType.LOAD)
	Product findByProductId(Integer id);
}