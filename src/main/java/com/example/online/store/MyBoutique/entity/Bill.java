package com.example.online.store.MyBoutique.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BILLS")

public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private double subTotal;

	private double total;

	private double tax;

	@OneToMany(cascade=CascadeType.REMOVE,fetch = FetchType.EAGER)
	private List<LineItem> lineItems;

	public Bill() {
		super();
	}

	public Bill(double total, double subTotal, double tax) {
		super();
		this.tax = tax;
		this.total= total;
		this.subTotal = subTotal;
	}

	public Bill(List<LineItem> lineItems) {
		super();
		this.lineItems = lineItems;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}



}
