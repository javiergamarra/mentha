package com.nhpatt.mentha.model;

import java.io.Serializable;

public class Transaction implements Serializable {

	private static final long serialVersionUID = 1L;
	private String amount;
	private String category;

	public Transaction(final String stringExtra) {
		amount = stringExtra;
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

}
