package com.nhpatt.mentha.activity;

import java.util.ArrayList;
import java.util.List;

import com.nhpatt.mentha.model.Transaction;

import android.app.Application;

public class Mentha extends Application {

	private final List<Transaction> transactions = new ArrayList<Transaction>();

	public List<Transaction> getTransactions() {
		return transactions;
	}

}
