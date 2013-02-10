package com.nhpatt.mentha.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.nhpatt.mentha.R;

public class MainActivity extends Activity {

	private static final String TAG = "MENTHA";

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Log.e(TAG, "Starting MainActivity...");
	}
}
