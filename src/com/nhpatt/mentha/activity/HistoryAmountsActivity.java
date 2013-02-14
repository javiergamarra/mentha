package com.nhpatt.mentha.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.nhpatt.mentha.R;

public class HistoryAmountsActivity extends ListActivity {

	private ArrayAdapter<String> adapter;
	private final List<String> transactions = new ArrayList<String>();

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.history);

		transactions.add(getIntent().getStringExtra("amount"));

		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, transactions);
		setListAdapter(adapter);

	}

}
