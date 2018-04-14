package com.example.online.store.MyBoutique.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.online.store.MyBoutique.entity.Bill;
import com.example.online.store.MyBoutique.product.model.BillDetail;
import com.example.online.store.MyBoutique.rest.service.BillService;

@RestController
@RequestMapping("/rest")
public class BillController {

	@Autowired
	BillService billService;
	
	@RequestMapping(value = "/bills", method = RequestMethod.GET)
	public BillDetail createBill() {
		
		Bill bill = billService.createBill();
		
		return mapBillToBillDetail(bill);
	}

	private BillDetail mapBillToBillDetail(Bill bill) {
		double total = bill.getTotalValue();
		double subTotal = bill.getTotalCost();
		double tax = bill.getTotalTax();
		
		BillDetail billDetail = new BillDetail(total, subTotal, tax);
		System.out.println(billDetail.toString());
		return billDetail;
	}
	
}
