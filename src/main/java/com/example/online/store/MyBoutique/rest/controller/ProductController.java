package com.example.online.store.MyBoutique.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.h2.server.pg.PgServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.online.store.MyBoutique.entity.Product;
import com.example.online.store.MyBoutique.product.model.ProductDetail;
import com.example.online.store.MyBoutique.rest.service.ProductService;

@RestController
@RequestMapping("/rest")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/product")
	public List<ProductDetail> getProductsAdded() {
		List<ProductDetail> pDetails = new ArrayList<>();
		
		Iterable<Product> products = productService.findAllProduct();
		for (Product product : products) {
			ProductDetail detail = new ProductDetail();
			detail.setBarCode(product.getBarCodeId());
			detail.setName(product.getName());
			detail.setProductCategory(product.getProductCategory());
			detail.setRate(product.getRate());
			
			pDetails.add(detail);
		}
		return pDetails;
	}

	@PostMapping("/product")
	public String addProduct(@RequestBody ProductDetail detail) {
		
		Product product = productService.createProduct(detail);
		ProductDetail productDetail = new ProductDetail();
		productDetail.setName(product.getName());
		productDetail.setBarCode(product.getBarCodeId());
		productDetail.setRate(product.getRate());
		productDetail.setProductCategory(product.getProductCategory());
		
		return productDetail.toString();
	}
}
