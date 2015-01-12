package com.longhui.fragment;

import com.longhui.massescommentsap.R;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class GroupBuyFragment extends Fragment {
	private static final String TAG = "GroupBuyFragment";
	private IFragmentChange change;
	public GroupBuyFragment( ) {
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		Log.d(TAG, "---onAttach----");
		this.change = (IFragmentChange)activity;
		super.onAttach(activity);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.d(TAG, "---onCreate----");
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.d(TAG, "---onCreateView----");
		View view = inflater.inflate(R.layout.group_buy_layout, null);
		return view;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.d(TAG, "---onActivityCreated----");
		super.onActivityCreated(savedInstanceState);
	}
	
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		Log.d(TAG, "---onStart----");
		super.onStart();
	}
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		Log.d(TAG, "---onResume----");
		super.onResume();
	}
	
	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		Log.d(TAG, "---onPause----");
		super.onPause();
	}
	
	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		Log.d(TAG, "---onStop----");
		super.onStop();
	}
	
	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		Log.d(TAG, "---onDestroyView----");
		super.onDestroyView();
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		Log.d(TAG, "---onDestroy----");
		super.onDestroy();
	}
	
	@Override
	public void onDetach() {
		// TODO Auto-generated method stub
		Log.d(TAG, "---onDetach----");
		super.onDetach();
	}
	
}
