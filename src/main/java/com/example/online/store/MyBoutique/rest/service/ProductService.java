package com.example.online.store.MyBoutique.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.online.store.MyBoutique.entity.Product;
import com.example.online.store.MyBoutique.entity.repository.ProductRepository;
import com.example.online.store.MyBoutique.product.model.ProductDetail;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public Product createProduct(ProductDetail detail) {
		Product product = new Product();
		product.setBarCodeId(detail.getBarCode());
		product.setName(detail.getName());
		product.setProductCategory(detail.getProductCategory());
		product.setRate(detail.getRate());

		product = productRepository.save(product);
		return product;
	}
	
	public Iterable<Product> findAllProduct() {
		return productRepository.findAll();
	}
}
