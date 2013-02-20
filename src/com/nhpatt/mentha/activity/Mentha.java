package com.nhpatt.mentha.activity;

import java.util.ArrayList;
import java.util.List;

import com.nhpatt.mentha.model.Transaction;

import android.app.Application;

public class Mentha extends Application {

	public static final String USER = "user";
	public static final String PREFERENCES = "preferences";
	public static final String TRANSACTION = "transaction";

	private final List<Transaction> transactions = new ArrayList<Transaction>();

	public List<Transaction> getTransactions() {
		return transactions;
	}

}
