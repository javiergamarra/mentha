package com.nhpatt.mentha.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.nhpatt.mentha.R;

public class HistoryAmountsActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.history);

		Button button = (Button) findViewById(R.id.history);
		button.setOnClickListener(this);
	}

	@Override
	public void onClick(final View arg0) {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
}
