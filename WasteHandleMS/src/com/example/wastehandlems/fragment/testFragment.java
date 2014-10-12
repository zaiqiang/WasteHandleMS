package com.example.wastehandlems.fragment;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wastehandlems.R;
import com.example.wastehandlems.WasteHandleConfiguration;

public class testFragment extends AbstractWHMSFragment {

	@Override
	protected int getLayoutResourceId() {
		return R.layout.fragment_test;
	}

	@Override
	protected void onWasteHandleInitView() {
		final TextView tv=(TextView) findViewById(R.id.textView1);
		final ImageView iv=(ImageView) findViewById(R.id.imageView1);
		Button btn=(Button) findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				tv.setText(WasteHandleConfiguration.getInstance().getProjectFolderName());
			}
		});
	}

	@Override
	public String getTransactionTag() {
		return "fragment test";
	}

}
