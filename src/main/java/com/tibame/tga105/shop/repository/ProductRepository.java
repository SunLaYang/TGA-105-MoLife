package com.tibame.tga105.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tibame.tga105.shop.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
