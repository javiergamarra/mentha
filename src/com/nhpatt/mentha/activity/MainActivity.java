package com.nhpatt.mentha.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.nhpatt.mentha.R;

public class MainActivity extends Activity implements OnClickListener {

	private static final String TAG = "MENTHA";

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button save = (Button) findViewById(R.id.save);

		save.setOnClickListener(this);
		Log.e(TAG, "Starting MainActivity...");
	}

	@Override
	public void onClick(final View v) {
		EditText editText = (EditText) findViewById(R.id.transaction);
		Log.e(TAG, editText.getText().toString());
	}
}
