package com.nhpatt.mentha.activity;

import java.util.List;

import com.nhpatt.mentha.R;
import com.nhpatt.mentha.model.Transaction;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class AmountAdapter extends ArrayAdapter<Transaction> {

	public AmountAdapter(final HistoryAmountsActivity context,
			final int resource, final List<Transaction> transactions) {
		super(context, resource, transactions);
	}

	@Override
	public View getView(final int position, View convertView,
			final ViewGroup parent) {
		if (convertView == null) {
			LayoutInflater vi = (LayoutInflater) getContext().getSystemService(
					Context.LAYOUT_INFLATER_SERVICE);
			convertView = vi.inflate(R.layout.row, null);
		}

		Transaction transaction = getItem(position);
		TextView amount = (TextView) convertView.findViewById(R.id.amount);
		amount.setText(transaction.getAmount());
		TextView category = (TextView) convertView.findViewById(R.id.category);
		category.setText(transaction.getCategory());

		return convertView;
	}
}
