package com.example.online.store.MyBoutique.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.example.online.store.MyBoutique.model.ProductCategories;
import com.example.online.store.MyBoutique.product.model.ProductDetail;
import com.example.online.store.MyBoutique.util.ProductCategory;

@Controller
@RequestMapping(value="/product")
public class AddProductController {

	private static String URL = "http://localhost:8080/rest/product";
	@PostMapping(params="categoryA")
	public String addProductA(@ModelAttribute("model") ProductCategories categories, Model model) {
		createProduct(categories.getCategoryAproducts());

		model.addAttribute("productsA", getCategoryAProducts());
		model.addAttribute("productsB", getCategoryBProducts());
		model.addAttribute("productsC", getCategoryCProducts());
		model.addAttribute("productAdded", "successfully added");
		return "products";
		
	}

	@PostMapping(params="categoryB")
	public String addProductB(@ModelAttribute("model") ProductCategories categories, Model model) {
		createProduct(categories.getCategoryBproducts());
		
		model.addAttribute("productsA", getCategoryAProducts());
		model.addAttribute("productsB", getCategoryBProducts());
		model.addAttribute("productsC", getCategoryCProducts());
		model.addAttribute("productAdded", "successfully added");
		return "products";
		
	}
	
	@PostMapping(params="categoryC")
	public String addProductC(@ModelAttribute("model") ProductCategories categories, Model model) {
		createProduct(categories.getCategoryCproducts());

		model.addAttribute("productsA", getCategoryAProducts());
		model.addAttribute("productsB", getCategoryBProducts());
		model.addAttribute("productsC", getCategoryCProducts());
		model.addAttribute("productAdded", "successfully added");
		return "products";
		
	}
	
	private void createProduct(List<String> categories) {
		for (String productName : categories) {
			ProductDetail productDetail = new ProductDetail(productName, "A-product-001"+Math.random(), 20, ProductCategory.A);
			RestTemplate restTemplate = new RestTemplate();
			String productInfo = restTemplate.postForObject(URL, productDetail, String.class);
			System.out.println(productInfo);
		}
	}
	
	private List<String> getCategoryBProducts() {
		List<String> productB = new ArrayList<String>();
		productB.add("Apple Tv");
		productB.add("IPhone X");
		productB.add("Apple Watch");
		return productB;
	}
	
	private List<String> getCategoryCProducts() {
		List<String> productC = new ArrayList<String>();
		productC.add("Wooden Cup");
		productC.add("Ball pen");
		productC.add("Fountain Pen");
		return productC;
	}
	
	private List<String> getCategoryAProducts() {
		List<String> productA = new ArrayList<String>();
		productA.add("Shampoo");
		productA.add("Face Wash");
		return productA;
	}
}
