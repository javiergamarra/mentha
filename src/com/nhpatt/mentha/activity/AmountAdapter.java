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
		TextView row1 = (TextView) convertView.findViewById(R.id.row1);
		row1.setText(transaction.getAmount());
		TextView row2 = (TextView) convertView.findViewById(R.id.row2);
		row2.setText(transaction.getCategory());

		return convertView;
	}
}
