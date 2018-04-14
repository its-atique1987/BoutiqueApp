package com.example.online.store.MyBoutique.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.example.online.store.MyBoutique.model.ProductCategories;

@Controller
public class ProductListController {

	@Autowired
	private ProductCategories productCategories;

	@GetMapping("/welcome")
	public String welcome(Model model) {
		model.addAttribute("name", "atique");
		return "welcome";
	}

	@GetMapping("/products")
	public ModelAndView productlist() {
		/*productCategories.setCategoryBproducts(getCategoryBProducts());
		productCategories.setCategoryCproducts(getCategoryCProducts());
		productCategories.setCategoryAproducts(getCategoryAProducts());*/
		ModelAndView modelAndView = new ModelAndView("products", "model", productCategories);
		return modelAndView;
	}
	
	@ModelAttribute("productsB")
	public List<String> getCategoryBProducts() {
		List<String> productB = new ArrayList<String>();
		productB.add("Apple Tv");
		productB.add("IPhone X");
		productB.add("Apple Watch");
		return productB;
	}
	
	@ModelAttribute("productsC")
	public List<String> getCategoryCProducts() {
		List<String> productC = new ArrayList<String>();
		productC.add("Wooden Cup");
		productC.add("Ball pen");
		productC.add("Fountain Pen");
		return productC;
	}
	
	@ModelAttribute("productsA")
	public List<String> getCategoryAProducts() {
		List<String> productA = new ArrayList<String>();
		productA.add("Shampoo");
		productA.add("Face Wash");
		return productA;
	}
}
