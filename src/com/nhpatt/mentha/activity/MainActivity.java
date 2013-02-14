package com.nhpatt.mentha.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nhpatt.mentha.R;

public class MainActivity extends Activity implements OnClickListener {

	private static final String TAG = "MENTHA";

	private final List<String> transactions = new ArrayList<String>();

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button save = (Button) findViewById(R.id.save);
		save.setOnClickListener(this);
	}

	@Override
	public void onClick(final View view) {
		EditText editText = (EditText) findViewById(R.id.transaction);
		String amount = editText.getText().toString();
		transactions.add(amount);
		Toast.makeText(this, "Adding amount: " + amount, Toast.LENGTH_SHORT)
				.show();
		Intent intent = new Intent(this, HistoryAmountsActivity.class);
		startActivity(intent);
	}
}
