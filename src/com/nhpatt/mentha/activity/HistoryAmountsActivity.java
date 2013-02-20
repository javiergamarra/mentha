package com.nhpatt.mentha.activity;

import static com.nhpatt.mentha.activity.Mentha.TRANSACTION;
import android.app.ListActivity;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.nhpatt.mentha.R;
import com.nhpatt.mentha.adapter.AmountAdapter;
import com.nhpatt.mentha.model.Transaction;

public class HistoryAmountsActivity extends ListActivity {

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.history);

		recoverUser();

		final Mentha mentha = (Mentha) getApplication();
		mentha.getTransactions().add(
				(Transaction) getIntent().getSerializableExtra(TRANSACTION));

		setListAdapter(new AmountAdapter(this,
				android.R.layout.simple_list_item_1, mentha.getTransactions()));
	}

	private void recoverUser() {
		final SharedPreferences preferences = getSharedPreferences(
				Mentha.PREFERENCES, MODE_PRIVATE);
		setTitle(getString(R.string.user_amounts,
				preferences.getString(Mentha.USER, "-")));
	}

}
