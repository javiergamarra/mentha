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

		final Button save = (Button) findViewById(R.id.save);
		save.setOnClickListener(this);

		saveUser();
	}

	private void saveUser() {
		final SharedPreferences.Editor editor = getSharedPreferences(
				Mentha.PREFERENCES, MODE_PRIVATE).edit();
		editor.putString(Mentha.USER, "nhpatt");
		editor.commit();
	}

	@Override
	public void onClick(final View view) {
		final EditText amount = (EditText) findViewById(R.id.amount);
		final EditText category = (EditText) findViewById(R.id.category);
		final Transaction transaction = new Transaction(amount.getText()
				.toString(), category.getText().toString());
		Toast.makeText(this,
				getString(R.string.adding_amount, transaction.getAmount()),
				Toast.LENGTH_SHORT).show();

		final Intent intent = new Intent(this, HistoryAmountsActivity.class);
		intent.putExtra(Mentha.TRANSACTION, transaction);
		startActivity(intent);
	}
}
