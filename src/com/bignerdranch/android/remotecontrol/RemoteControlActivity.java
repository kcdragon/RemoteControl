package com.bignerdranch.android.remotecontrol;

import android.content.*;
import android.content.pm.*;
import android.os.*;
import android.provider.*;
import android.support.v4.app.*;
import android.text.*;
import android.text.format.*;
import android.view.*;
import android.util.Log;
import android.widget.*;

public class RemoteControlActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment() {
	return new RemoteControlFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
	requestWindowFeature(Window.FEATURE_NO_TITLE);
	super.onCreate(savedInstanceState);
    }
}
