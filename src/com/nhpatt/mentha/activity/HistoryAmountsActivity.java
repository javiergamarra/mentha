package com.nhpatt.mentha.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;

import com.nhpatt.mentha.R;
import com.nhpatt.mentha.model.Transaction;

public class HistoryAmountsActivity extends ListActivity {

	private AmountAdapter adapter;
	private final List<Transaction> transactions = new ArrayList<Transaction>();

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.history);

		transactions.add(new Transaction(getIntent().getStringExtra("amount")));

		adapter = new AmountAdapter(this, android.R.layout.simple_list_item_1,
				transactions);
		setListAdapter(adapter);

	}

}
