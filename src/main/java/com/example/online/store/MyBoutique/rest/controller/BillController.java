package com.example.online.store.MyBoutique.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.online.store.MyBoutique.entity.Bill;
import com.example.online.store.MyBoutique.entity.LineItem;
import com.example.online.store.MyBoutique.product.model.BillDetail;
import com.example.online.store.MyBoutique.product.model.LineItemDetail;
import com.example.online.store.MyBoutique.rest.service.BillService;

@RestController
@RequestMapping("/rest")
public class BillController {

	@Autowired
	BillService billService;
	
	@RequestMapping(value = "/bills", method = RequestMethod.GET)
	public String createBill() {
		
		Bill bill = billService.createBill();
		
		return mapBillToBillDetail(bill).toString();
	}

	private BillDetail mapBillToBillDetail(Bill bill) {
		double total = bill.getTotal();
		double subTotal = bill.getSubTotal();
		double tax = bill.getTax();
		
		List<LineItemDetail> lineItemDetails = mapLineItemToLineItemDetail(bill.getLineItems());
		BillDetail billDetail = new BillDetail(total, subTotal, tax, lineItemDetails);
		System.out.println(billDetail.toString());
		return billDetail;
	}

	private List<LineItemDetail> mapLineItemToLineItemDetail(List<LineItem> items) {
		List<LineItemDetail> lineItemDetails = new ArrayList<LineItemDetail>();
		for (LineItem lineItem : items) {
			LineItemDetail detail = new LineItemDetail();
			detail.setProductName(lineItem.getProduct().getName());
			detail.setProductRate(lineItem.getProduct().getRate());
			detail.setQuantity(lineItem.getQuantity());
			detail.setTotalValue(lineItem.getTotalValue());
			
			lineItemDetails.add(detail);
			
		}
		return lineItemDetails;
	}
	
}
