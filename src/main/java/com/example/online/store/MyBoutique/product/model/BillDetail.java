package com.example.online.store.MyBoutique.product.model;

public class BillDetail {

	private int noOfItems;

	private double subTotal;

	private double total;

	private double tax;

	public BillDetail(double total, double subTotal, double tax) {
		this.tax = tax;
		this.total= total;
		this.subTotal = subTotal;
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
		return "BillDetail -- "
				+ "Total Value = "+total+ " Sub Total = "+subTotal
				+" Total Tax = "+tax;
	}
	
}
