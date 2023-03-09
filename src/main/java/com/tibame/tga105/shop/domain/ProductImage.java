package com.tibame.tga105.shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_image")
public class ProductImage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_image_id")
	private Integer productImageId;

	@Column(name = "product_id")
	private Integer productId;

	@Column(name = "product_image_type")
	private Integer productImageType;

	@Column(name = "product_image")
	private String productImage;

	public Integer getProductImageId() {
		return productImageId;
	}

	public void setProductImageId(Integer productImageId) {
		this.productImageId = productImageId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getProductImageType() {
		return productImageType;
	}

	public void setProductImageType(Integer productImageType) {
		this.productImageType = productImageType;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	@Override
	public String toString() {
		return "ProductImageBean [productImageId=" + productImageId + ", productId=" + productId + ", productImageType="
				+ productImageType + ", productImage=" + productImage + "]";
	}

}
