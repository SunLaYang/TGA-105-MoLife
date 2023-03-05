package com.tibame.tga105.domain;

public class ProductBean {
	private Integer id;
	private String name;
	private Double price;
	private java.util.Date make;
	private Integer expire;

	@Override
	public String toString() {
		return "model.ProductBean ["+ id+ ","+ name+ ","+ price+ ","+ make+ ","+ expire+ "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public java.util.Date getMake() {
		return make;
	}
	public void setMake(java.util.Date make) {
		this.make = make;
	}
	public Integer getExpire() {
		return expire;
	}
	public void setExpire(Integer expire) {
		this.expire = expire;
	}
}
