package com.nhpatt.mentha.activity;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.nhpatt.mentha.R;

public class SettingsActivity extends Activity {
	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getFragmentManager().beginTransaction()
				.replace(android.R.id.content, new SettingsFragment()).commit();

	}

	public static class SettingsFragment extends PreferenceFragment {
		@Override
		public void onCreate(final Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			addPreferencesFromResource(R.xml.preferences);

		}
	}

}