package com.longhui.massescommentsap;

import java.util.ArrayList;
import java.util.List;

import android.R.integer;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.nfc.TagLostException;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.util.SparseArray;
import android.view.View;
import android.widget.LinearLayout;

import com.longhui.adapter.FragmentViewPagerAdapter;
import com.longhui.adapter.IExtraPageChangeListener;
import com.longhui.fragment.GroupBuyFragment;
import com.longhui.fragment.IFragmentChange;
import com.longhui.fragment.MoreFragment;
import com.longhui.fragment.MyFragment;
import com.longhui.fragment.SearchFragment;
import com.longhui.fragment.SignInFragment;

public class MainFrameActivity extends Activity implements IExtraPageChangeListener,IFragmentChange{
	
	private ViewPager contentVPager;
	private FragmentManager fragmentManager;
	private FragmentTransaction fragmentTransaction;
	private List<Fragment> fragments;
	private FragmentViewPagerAdapter fragmentAdapter;
	
	private SparseArray<LinearLayout> tabLayouts;
	private SparseArray<Integer> pageIndexMap;    //tabLayoutsId 和 PageIdex 进行映射
	private int[] tabLayoutIds ;
	private TabClickListener clickLister = new TabClickListener();
	
	private static final int SEARCH_PAGE = 0;
	private static final int GROUP_BUY_PAGE = 1;
	private static final int SIGN_IN_PAGE = 2;
	private static final int MY_PAGE = 3;
	private static final int MORE_PAGE = 4;
	
	private int curentPageIdex = SEARCH_PAGE;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_frame_main);
		initView();
		initData();
	}
	
	private void initView(){
		contentVPager = (ViewPager)findViewById(R.id.content);
		tabLayoutIds = new int[]{//getResources().getIntArray(R.array.tab_layout_id);
				R.id.search_layout,R.id.group_buy_layout,R.id.sign_in_layout,R.id.my_layout,
				R.id.more_layout
		};
		tabLayouts = new SparseArray<LinearLayout>();
		pageIndexMap = new SparseArray<Integer>();
		for(int i=0;i<tabLayoutIds.length;i++){
			int viewId = tabLayoutIds[i];
			System.out.printf("0x%X", viewId);
			LinearLayout layout = (LinearLayout)findViewById(viewId);
			layout.setClickable(true);
			layout.setOnClickListener(clickLister);
			tabLayouts.put(viewId , layout);
			pageIndexMap.put(viewId,i);
		}
	}
	
	private void initData(){
		fragmentManager = this.getFragmentManager();
		fragments = new ArrayList<Fragment>();
		fragments.add(new SearchFragment());
		fragments.add(new GroupBuyFragment());
		fragments.add(new SignInFragment());
		fragments.add(new MyFragment());
		fragments.add(new MoreFragment());
		fragmentAdapter = new FragmentViewPagerAdapter(fragmentManager, contentVPager, fragments);
		fragmentAdapter.setExtraPListener(this);
		contentVPager.setAdapter(fragmentAdapter);
		contentVPager.setCurrentItem(SEARCH_PAGE);
		tabLayouts.get(tabLayoutIds[SEARCH_PAGE]).setSelected(true);
	}
	
	private void setCurrentItemView(int tabId){
		if(curentPageIdex == tabId){
			return;
		}
		tabLayouts.get(tabLayoutIds[curentPageIdex]).setSelected(false);
		tabLayouts.get(tabId).setSelected(true);
		contentVPager.setCurrentItem(pageIndexMap.get(tabId));
		curentPageIdex = pageIndexMap.get(tabId);
	}
	
	private class TabClickListener implements View.OnClickListener{
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int id = v.getId();
			setCurrentItemView(id);
		}
	}
	
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onPageSelected(int pageIdex) {
		// TODO Auto-generated method stub
		int viewId = tabLayoutIds[pageIdex];
		setCurrentItemView(viewId);
	}
	
	@Override
	public void transmitData(String tag, Bundle boundle) {
		// TODO Auto-generated method stub
		
	}
}
