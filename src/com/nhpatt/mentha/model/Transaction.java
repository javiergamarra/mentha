package com.nhpatt.mentha.model;

import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Transaction implements Serializable {

	private static final long serialVersionUID = 1L;

	@DatabaseField(generatedId = true)
	private Long id;
	@DatabaseField
	private String amount;
	@DatabaseField
	private String category;

	public Transaction() {
	}

	public Transaction(final String amount, final String category) {
		this.amount = amount;
		this.category = category;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(final String amount) {
		this.amount = amount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(final String category) {
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

}
