package com.example.onefeed;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

public class MySettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.settings_pref, rootKey);
    }

    /*
    Sommer:
    I was going to try and get the notifications page working in settings but
    android studio keeps telling me preferences is deprecated and I don't have
    enough time to find an alternative.

    public void onPreferenceTreeClick (Preference preference) {

    }
     */
}