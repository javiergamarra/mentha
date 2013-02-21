package com.nhpatt.mentha.model;

import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;
	@DatabaseField
	private String name;
	@DatabaseField
	private Double amount;

	public Category() {
	}

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
