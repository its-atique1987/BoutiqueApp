package com.example.online.store.MyBoutique.product.model;

import com.example.online.store.MyBoutique.util.ProductCategory;

public class ProductDetail {

	private String name;
	private String barCode;
	private ProductCategory productCategory;
	private double rate;
	
	public ProductDetail(String name, String barCode, double rate, ProductCategory category) {
		this.name = name;
		this.barCode = barCode;
		this.rate = rate;
		this.productCategory = category;
	}

	public ProductDetail() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public ProductCategory getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Name: "+name+" Category: "+productCategory.name()+ " Rate: "+rate;
	}
	
}
