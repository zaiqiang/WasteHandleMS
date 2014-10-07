package com.example.wastehandlems.activity;

import com.example.wastehandlems.fragment.AbstractWHMSFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;

public abstract class AbstractWasteHandleActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 onWasteHandleCreate(savedInstanceState);
	}
	
	abstract protected void onWasteHandleCreate(Bundle savedInstanceState);
	
	public void navigationToFragment(AbstractWHMSFragment WHMSFragment){
		
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		ft.replace(getContainerResourceId(), WHMSFragment, WHMSFragment.getTransactionTag());
		ft.commitAllowingStateLoss();
		getSupportFragmentManager().executePendingTransactions();
	}
	
	public void addFragment(AbstractWHMSFragment WHMSFragment){
		
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		
		ft.add(getContainerResourceId(), WHMSFragment, WHMSFragment.getTransactionTag());
		ft.addToBackStack(WHMSFragment.getTransactionTag());
		ft.commitAllowingStateLoss();
		getSupportFragmentManager().executePendingTransactions();
		
	}
	
	protected int getContainerResourceId() {
		return -1;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch(item.getItemId()) {
		
    	case android.R.id.home:
    		onBackPressed();
     		return true;
     	
     	default:
     		break;
    	}
		return super.onOptionsItemSelected(item);
	}

}
