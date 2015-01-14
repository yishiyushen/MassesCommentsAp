package com.longhui.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.longhui.massescommentsap.R;
import com.longhui.massescommentsap.SearchShops;

public class SearchFragment extends Fragment{
	private static final String TAG = "SearchFragment";
	private IFragmentChange change;
	private ImageView mFoodSearchImgBt;
	private ImageView mPotSearchImgBt;
	private ImageView mHotelSearchImgBt;
	private ImageView mPubSearchImgBt;
	private ImageView mSnakesSearchImgBt;
	private ImageView mMoreSearchImgBt;
	
	private RelativeLayout mMemberCard;
	private RelativeLayout mSearchWholeCity;
	private RelativeLayout mRanking;
	private RelativeLayout mCoupon;
	
	private Context context;
	
	public SearchFragment() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		Log.d(TAG, "---onAttach----");
		this.change = (IFragmentChange)activity;
		this.context = activity;
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
		View view = inflater.inflate(R.layout.search_layout, null);
		ClickListener listener = new ClickListener();
		mFoodSearchImgBt = (ImageView) view.findViewById(R.id.food_img);
		mPotSearchImgBt = (ImageView) view.findViewById(R.id.view_spot);
		mHotelSearchImgBt = (ImageView) view.findViewById(R.id.hotel_img);
		mPubSearchImgBt = (ImageView) view.findViewById(R.id.bar);
		mSnakesSearchImgBt = (ImageView) view.findViewById(R.id.snake);
		mMoreSearchImgBt = (ImageView) view.findViewById(R.id.more_classify);
		
		mFoodSearchImgBt.setOnClickListener(listener);
		mPotSearchImgBt.setOnClickListener(listener);
		mHotelSearchImgBt.setOnClickListener(listener);
		mPubSearchImgBt.setOnClickListener(listener);
		mSnakesSearchImgBt.setOnClickListener(listener);
		mMoreSearchImgBt.setOnClickListener(listener);
		
		mMemberCard = (RelativeLayout)view.findViewById(R.id.member_card);
		mSearchWholeCity = (RelativeLayout)view.findViewById(R.id.search_all);
		mRanking = (RelativeLayout)view.findViewById(R.id.ranking_layout);
		mCoupon = (RelativeLayout)view.findViewById(R.id.coupon_layout);
		
		mMemberCard.setOnClickListener(listener);
		mSearchWholeCity.setOnClickListener(listener);
		mRanking.setOnClickListener(listener);
		mCoupon.setOnClickListener(listener);
		return view;
	}
	
	private class ClickListener implements View.OnClickListener{
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int id = v.getId();
			Intent intent;
			switch(id){
			case R.id.food_img:
				intent = new Intent(context, SearchShops.class);
				startActivity(intent);
				break;
			case R.id.view_spot:
				intent = new Intent(context, SearchShops.class);
				startActivity(intent);
				break;
			case R.id.hotel_img:
				intent = new Intent(context, SearchShops.class);
				startActivity(intent);
				break;
			case R.id.bar:
				intent = new Intent(context, SearchShops.class);
				startActivity(intent);
				break;
			case R.id.snake:
				intent = new Intent(context, SearchShops.class);
				startActivity(intent);
				break;
			case R.id.more_classify:
				break;
			case R.id.member_card:
				break;
			case R.id.search_all:
				break;
			case R.id.ranking:
				break;
			case R.id.coupon:
				break;
			}
		}
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
