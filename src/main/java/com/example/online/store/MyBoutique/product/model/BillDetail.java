package com.example.online.store.MyBoutique.product.model;

import java.util.List;

public class BillDetail {

	private int noOfItems;

	private double subTotal;

	private double total;

	private double tax;
	
	private List<LineItemDetail> lineItemDetails;
	

	public BillDetail(double total, double subTotal, double tax, List<LineItemDetail> details) {
		this.tax = tax;
		this.total= total;
		this.subTotal = subTotal;
		this.lineItemDetails = details;
	}

	public int getNoOfItems() {
		return noOfItems;
	}

	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}
	
	@Override
	public String toString() {
		StringBuilder builder= new StringBuilder();
		builder.append(" Name   Quantity   Rate   Total");
		builder.append(System.getProperty("line.separator"));
		builder.append("----------------------------------");
		for (LineItemDetail item : lineItemDetails) {
			String itemInfo = item.getProductName() 
					+ " "
					+ item.getQuantity()
					+ " "
					+ item.getProductRate()
					+" "
					+item.getTotalValue();
			builder.append(itemInfo);
			builder.append(System.getProperty("line.separator"));
		}
		builder.append("----------------------------------");
		builder.append(System.getProperty("line.separator"));
		builder.append("Total Value = "+total);
		builder.append(System.getProperty("line.separator"));
		builder.append("Sub Total = "+subTotal);
		builder.append(System.getProperty("line.separator"));
		builder.append("Total tax = "+tax);
		
		return builder.toString();
	}
	
}
