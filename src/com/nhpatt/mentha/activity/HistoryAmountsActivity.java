package com.nhpatt.mentha.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.nhpatt.mentha.R;
import com.nhpatt.mentha.model.Transaction;

public class HistoryAmountsActivity extends ListActivity {

	private AmountAdapter adapter;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.history);

		SharedPreferences preferences = getSharedPreferences("preferences",
				MODE_PRIVATE);
		setTitle(preferences.getString("nombre", ""));

		Mentha mentha = (Mentha) getApplication();
		mentha.getTransactions().add(
				(Transaction) getIntent().getSerializableExtra("transaction"));

		adapter = new AmountAdapter(this, android.R.layout.simple_list_item_1,
				mentha.getTransactions());
		setListAdapter(adapter);

	}

}
