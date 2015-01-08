package com.longhui.adapter;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;

public class FragmentViewPagerAdapter extends PagerAdapter implements
		OnPageChangeListener {
	
	private List<Fragment> frgList;
	private FragmentManager fragmentManager;
	private ViewPager viewPager;
	private int curentPageIndex;
	
	private IExtraPageChangeListener extraPListener;
	
	public FragmentViewPagerAdapter(FragmentManager manager, ViewPager viewPager, List<Fragment> lists) {
		// TODO Auto-generated constructor stub
		this.fragmentManager=manager;
		this.viewPager = viewPager;
		this.frgList = lists;
		this.viewPager.setOnPageChangeListener(this);
		this.viewPager.setAdapter(this);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return frgList.size();
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// TODO Auto-generated method stub
		//super.destroyItem(container, position, object);
		container.removeView(frgList.get(position).getView());
	}


	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		// TODO Auto-generated method stub
		//return super.instantiateItem(container, position);
		Fragment fragment = frgList.get(position);
		View view = fragment.getView();
		if(!fragment.isAdded()){
			FragmentTransaction ft = fragmentManager.beginTransaction();
			ft.add(fragment,fragment.getClass().getSimpleName());
			ft.commit();
			fragmentManager.executePendingTransactions();
		}
		
		if(fragment.getView().getParent() == null){
			container.addView(view);
		}
		
		return view;
	}
	
	public int getCurentPageIndex() {
		return curentPageIndex;
	}
	

	public IExtraPageChangeListener getExtraPListener() {
		return extraPListener;
	}

	public void setExtraPListener(IExtraPageChangeListener extraPListener) {
		this.extraPListener = extraPListener;
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		if(extraPListener != null){
			extraPListener.onPageScrollStateChanged(arg0);
		}
	}
	
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		if(extraPListener != null){
			extraPListener.onPageScrolled(arg0, arg1, arg2);
		}
	}

	@Override
	public void onPageSelected(int position) {
		// TODO Auto-generated method stub
		frgList.get(curentPageIndex).onPause();
		if(frgList.get(position).isAdded()){
			frgList.get(position).onResume();
		}
		curentPageIndex = position;
		if(extraPListener != null){
			extraPListener.onPageSelected(position);
		}
		
	}


	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0==arg1;
	}

}
