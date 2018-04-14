package com.example.online.store.MyBoutique.rest.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.online.store.MyBoutique.entity.Bill;
import com.example.online.store.MyBoutique.entity.LineItem;
import com.example.online.store.MyBoutique.entity.Product;
import com.example.online.store.MyBoutique.entity.repository.BillRepository;
import com.example.online.store.MyBoutique.entity.repository.LineItemRepository;
import com.example.online.store.MyBoutique.entity.repository.ProductRepository;
import com.example.online.store.MyBoutique.product.model.BillDetail;
import com.example.online.store.MyBoutique.util.ProductCategory;

@Service
public class BillService {

	@Autowired
	private BillRepository billRepository;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private LineItemRepository lineItemRepository;

	@PostMapping("/bill")
	public Bill createBill() {
		
		Bill bill = billRepository.save(new Bill(0.0, 0.0, 0));
		
		List<LineItem> savedItems = addProductToBill(bill);
		bill.setLineItems(savedItems);
		Bill bill2 = billRepository.save(bill);
		return computeTotalValues(bill2);
	}

	private Bill computeTotalValues(Bill bill) {

		double total = 0;
		double subtotal = 0;

		if (null != bill.getLineItems()) {
			List<LineItem> lineItems = bill.getLineItems();
			Iterator<LineItem> lineItemsIter = lineItems.iterator();
			while (lineItemsIter.hasNext()) {
				LineItem li = lineItemsIter.next();
				total += li.getTotalValue();
				subtotal += li.getQuantity() * li.getProduct().getRate();
			}
		}
		bill.setTax(total-subtotal);
		bill.setTotal(total);
		bill.setSubTotal(subtotal);
		return billRepository.save(bill);
	}

	private List<LineItem> addProductToBill(Bill bill) {
		Iterable<Product> productsInCart = productRepository.findAll();
		List<LineItem> lineItems = new ArrayList<>();
		for (Product product : productsInCart) {
			 long quantity = productRepository.countByName(product.getName());
			 LineItem lineItem = createLineItems(quantity, product);
			 lineItems.add(lineItem);
		}
		lineItemRepository.saveAll(lineItems);
		
		//bill.setLineItems(lineItems);
		return lineItems;
	}

	public LineItem  createLineItems(long quantity, Product product) {
		double totalSaleValue = computeTotalSaleValueForItem(quantity, product);
		 return new LineItem(product, quantity, totalSaleValue);
	}

	private double computeTotalSaleValueForItem(long quantity, Product product) {
		double totalSaleValue = 0;
		if (ProductCategory.A == product.getProductCategory()) {
			totalSaleValue = quantity * product.getRate() * 1.1;

		} else if (ProductCategory.B == product.getProductCategory()) {
			totalSaleValue = quantity * product.getRate() * 1.2;

		} else if (ProductCategory.C == product.getProductCategory()) {
			totalSaleValue = quantity * product.getRate();
		}
		return totalSaleValue;
	}
}