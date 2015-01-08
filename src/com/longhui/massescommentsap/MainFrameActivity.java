package com.longhui.massescommentsap;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

public class MainFrameActivity extends Activity {
	
	private ViewPager contentVPager;
	private FragmentManager fragmentManager;
	private FragmentTransaction fragmentTransaction;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_frame_main);
		initView();
	}
	
	private void initView(){
		contentVPager = (ViewPager)findViewById(R.id.content);
		fragmentManager = this.getFragmentManager();

	}
}
