package com.nhpatt.mentha.model;

import java.io.Serializable;

public class Category implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private Double amount;

	public Category(final String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(final Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return name;
	}

	public static Category[] getAllCategories() {
		return new Category[] { new Category("food"), new Category("gifts"),
				new Category("trips") };
	}
}
