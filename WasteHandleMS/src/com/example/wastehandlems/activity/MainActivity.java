package com.example.wastehandlems.activity;


import android.os.Bundle;

import com.example.wastehandlems.R;
import com.example.wastehandlems.fragment.testFragment;

public class MainActivity extends AbstractWasteHandleActivity {

	@Override
	protected void onWasteHandleCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_main);
		navigationToFragment(new testFragment());
	}

	@Override
	protected int getContainerResourceId() {
		return R.id.container;
	}

}
