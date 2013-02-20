package com.nhpatt.mentha.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.nhpatt.mentha.R;
import com.nhpatt.mentha.activity.HistoryAmountsActivity;
import com.nhpatt.mentha.model.Transaction;

public class AmountAdapter extends ArrayAdapter<Transaction> {

	public AmountAdapter(final HistoryAmountsActivity context,
			final int resource, final List<Transaction> transactions) {
		super(context, resource, transactions);
	}

	@Override
	public View getView(final int position, final View convertView,
			final ViewGroup parent) {
		View row = convertView;
		if (row == null) {
			final LayoutInflater vi = (LayoutInflater) getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = vi.inflate(R.layout.row, null);
		}

		final Transaction transaction = getItem(position);
		final TextView amount = (TextView) row.findViewById(R.id.amount);
		amount.setText(transaction.getAmount());

		final TextView category = (TextView) row.findViewById(R.id.category);
		category.setText(transaction.getCategory());

		return row;
	}
}
