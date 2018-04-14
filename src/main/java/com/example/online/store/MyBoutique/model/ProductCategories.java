package com.example.online.store.MyBoutique.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ProductCategories {

	private List<String> categoryAproducts;
	private List<String> categoryBproducts;
	private List<String> categoryCproducts;

	public List<String> getCategoryAproducts() {
		return categoryAproducts;
	}
	public void setCategoryAproducts(List<String> categoryAproducts) {
		this.categoryAproducts = categoryAproducts;
	}
	public List<String> getCategoryBproducts() {
		return categoryBproducts;
	}
	public void setCategoryBproducts(List<String> categoryBproducts) {
		this.categoryBproducts = categoryBproducts;
	}
	public List<String> getCategoryCproducts() {
		return categoryCproducts;
	}
	public void setCategoryCproducts(List<String> categoryCproducts) {
		this.categoryCproducts = categoryCproducts;
	}
}
