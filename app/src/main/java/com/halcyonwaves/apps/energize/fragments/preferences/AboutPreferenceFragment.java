package com.halcyonwaves.apps.energize.fragments.preferences;

import android.annotation.TargetApi;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.util.Log;
import com.halcyonwaves.apps.energize.R;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class AboutPreferenceFragment extends PreferenceFragment {

	private final static String TAG = "AboutPreference";

	private String getSoftwareVersion() {
		try {
			PackageInfo packageInfo = this.getActivity().getPackageManager().getPackageInfo(this.getActivity().getPackageName(), 0);
			return packageInfo.versionName + " (" + packageInfo.versionCode + ")";
		} catch (PackageManager.NameNotFoundException e) {
			Log.e(AboutPreferenceFragment.TAG, "Package name not found", e);
		}
		return "N/A";
	}

	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.addPreferencesFromResource(R.xml.pref_about);

		Preference appVersion = this.findPreference("developer.appVersion");
		appVersion.setSummary(this.getSoftwareVersion());
	}
}