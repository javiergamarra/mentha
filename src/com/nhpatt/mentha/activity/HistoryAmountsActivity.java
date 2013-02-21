package com.nhpatt.mentha.activity;

import java.util.List;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;

import com.j256.ormlite.android.apptools.OrmLiteBaseListActivity;
import com.nhpatt.mentha.R;
import com.nhpatt.mentha.adapter.AmountAdapter;
import com.nhpatt.mentha.database.DatabaseHelper;
import com.nhpatt.mentha.model.Transaction;

public class HistoryAmountsActivity extends
		OrmLiteBaseListActivity<DatabaseHelper> {

	private AmountAdapter adapter;
	private List<Transaction> transactions;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.history);

		recoverUser();

		transactions = getHelper().getTransactionDAO().queryForAll();
		adapter = new AmountAdapter(this, android.R.layout.simple_list_item_1,
				transactions);
		setListAdapter(adapter);

		registerForContextMenu(getListView());
	}

	@Override
	public void onCreateContextMenu(final ContextMenu menu, final View v,
			final ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		menu.add("delete");
	}

	@Override
	public boolean onContextItemSelected(final MenuItem item) {
		final AdapterContextMenuInfo info = (AdapterContextMenuInfo) item
				.getMenuInfo();
		final Transaction transaction = transactions.get(info.position);
		getHelper().getTransactionDAO().delete(transaction);
		transactions.remove(transaction);
		adapter.notifyDataSetChanged();
		return true;
	}

	private void recoverUser() {
		final SharedPreferences preferences = getSharedPreferences(
				Mentha.PREFERENCES, MODE_PRIVATE);
		setTitle(getString(R.string.user_amounts,
				preferences.getString(Mentha.USER, "-")));
	}

}
