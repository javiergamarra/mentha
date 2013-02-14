package com.nhpatt.mentha.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nhpatt.mentha.R;

public class MainActivity extends ListActivity implements OnClickListener {

	private static final String TAG = "MENTHA";
	private ArrayAdapter<String> adapter;
	private final List<String> transactions = new ArrayList<String>();

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button save = (Button) findViewById(R.id.save);
		save.setOnClickListener(this);

		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, transactions);
		setListAdapter(adapter);
	}

	@Override
	public void onClick(final View view) {
		EditText editText = (EditText) findViewById(R.id.transaction);
		String amount = editText.getText().toString();
		transactions.add(amount);
		Toast.makeText(this, "Adding amount: " + amount, Toast.LENGTH_SHORT)
				.show();
		adapter.notifyDataSetChanged();
		Log.e(TAG, amount);
	}
}
