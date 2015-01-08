package com.longhui.massescommentsap;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class LeadModeActivity extends Activity{

	private ViewPager mViewPager;
	private List<View> viewList = new ArrayList<View>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_leadmode);
		
		initView();
	}

	private void initView(){
		mViewPager = (ViewPager)findViewById(R.id.viewPager);
		
		ImageView imageView = new ImageView(this);
		imageView.setBackgroundResource(R.drawable.guidance_new1);
		viewList.add(imageView);
		ImageView imageView2 = new ImageView(this);
		imageView2.setBackgroundResource(R.drawable.guidance_new2);
		viewList.add(imageView2);
		View view = LayoutInflater.from(this).inflate(R.layout.lead_view, null);
		viewList.add(view);
		
		mViewPager.setAdapter(new ViewPagerAdapter());
	}
	
	private class ViewPagerAdapter extends PagerAdapter{

		public ViewPagerAdapter() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// TODO Auto-generated method stub
			//super.destroyItem(container, position, object);
			container.removeView(viewList.get(position));
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return viewList.size();
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// TODO Auto-generated method stub
			//return super.instantiateItem(container, position);
			View view = viewList.get(position);
			container.addView(view);
			if(position == viewList.size()-1){
				Button enter = (Button) view.findViewById(R.id.enter);
				enter.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(LeadModeActivity.this,MainFrameActivity.class);
						startActivity(intent);
						finish();
					}
				});
			}
			return view;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0==arg1;
		}
		
		
	}
	
}
