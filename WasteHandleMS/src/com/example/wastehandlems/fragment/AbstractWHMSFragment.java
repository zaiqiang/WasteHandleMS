package com.example.wastehandlems.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wastehandlems.activity.MainActivity;

public abstract class AbstractWHMSFragment extends Fragment {

	View rootView;
	MainActivity mCurrentActivity;
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		if(activity instanceof MainActivity) {
			mCurrentActivity=(MainActivity)activity;
		}
		onWasteHandleAttach();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		int layoutResourceId=getLayoutResourceId();
		if(layoutResourceId!=0){
			rootView=inflater.inflate(layoutResourceId, container,false);
			onWasteHandleInitView();
		}
		return rootView;
	}
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		onWasteHandleCreate(savedInstanceState);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		for(int i=0;i<menu.size();i++){
    		menu.removeGroup(i);
    	}
	}

	

	protected View getCurrentView(){
		return rootView;
	}
	
	protected View findViewById(int resourceId){
		return rootView.findViewById(resourceId);
	}
	
	
	protected MainActivity getCurrentActivity() {
		return mCurrentActivity;
	}
	

	

	@Override
	public void onStart() {
		super.onStart();
		onWasteHandleStart();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		onWasteHandleDestroy();
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		onWasteHandleDestroyView();
	}

	@Override
	public void onPause() {
		super.onPause();
		onWasteHandlePause();
	}
	
	@Override
	public void onResume() {
		super.onResume();
		onWasteHandleResume();
	}
	
	@Override
	public void onStop() {
		super.onStop();
		onWasteHandleStop();
	}
	
	abstract protected int getLayoutResourceId();
	
	abstract protected void onWasteHandleInitView();
	
	abstract public String getTransactionTag();
	
	
	protected void onWasteHandleAttach() {}
	
	protected void onWasteHandleCreate(Bundle savedInstanceState) {}
	
	protected void onWasteHandleStart() {}
	
	protected void onWasteHandleResume() {}
	
	protected void onWasteHandlePause() {}
	
	protected void onWasteHandleStop() {}
	
	protected void onWasteHandleDestroy() {}
	
	protected void onWasteHandleDestroyView() {}
}
