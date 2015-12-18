package com.brijesh.sharedpreferencesapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    private static final String PREFS_FILE = "com.brijesh.sharedpreferencesapp.preferences" ;
    private static final String KEY_EDITTEXT = "keyedittext";
    private EditText mEditText;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText)findViewById(R.id.editText);
        mSharedPreferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();

        mEditText.setText(mSharedPreferences.getString(KEY_EDITTEXT,""));


    }

    @Override
    protected void onPause() {
        super.onPause();

        mEditor.putString(KEY_EDITTEXT,mEditText.getText().toString());
        mEditor.apply();
    }
}
