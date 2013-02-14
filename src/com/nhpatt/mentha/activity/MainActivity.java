package com.nhpatt.mentha.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nhpatt.mentha.R;
import com.nhpatt.mentha.model.Transaction;

public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button save = (Button) findViewById(R.id.save);
		save.setOnClickListener(this);
		SharedPreferences.Editor editor = getSharedPreferences("preferences",
				MODE_PRIVATE).edit();
		editor.putString("nombre", "Ejemplo");
		editor.commit();
	}

	@Override
	public void onClick(final View view) {
		EditText amount = (EditText) findViewById(R.id.amount);
		EditText category = (EditText) findViewById(R.id.category);
		Transaction transaction = new Transaction(amount.getText().toString(),
				category.getText().toString());
		Toast.makeText(this, "Adding amount: " + transaction.getAmount(),
				Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(this, HistoryAmountsActivity.class);
		intent.putExtra("transaction", transaction);
		startActivity(intent);
	}
}
