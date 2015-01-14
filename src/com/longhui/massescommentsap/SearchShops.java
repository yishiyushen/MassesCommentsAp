package com.longhui.massescommentsap;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpStatus;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.longhui.adapter.ShopAdapter;
import com.longhui.net.HttpGetThread;
import com.longhui.net.ThreadPoolUtils;
import com.longhui.util.LoadImgUtil;
import com.longhui.vo.MyJson;
import com.longhui.vo.Shop;
/**
 * 用于搜索显示商店
 * @author zlh
 *
 */
public class SearchShops extends Activity {
	
	private ImageView mBackImgBt;
	private TextView mShopTitle;
	private ImageView mShoptitleImgBt;
	private TextView mShoplistWholeCity, mShopListFood,mShopListDefaultSort;
	private ListView mShopMainListV,mShopTopListV,mShopDefaultSortV,mShopClassfyListV,mShopClassfyListV2;
	private ListView mShopAreaListV,mShopAreaListV2;
	private LinearLayout mShopListMain1,mShopListMain2;
	private Button listBottomBt;
	
	private boolean bDisTpListV = false;
	private boolean bDisTreeListV1 = false;
	private boolean bDisTreeListV2 = false;
	private boolean bDisTreeListV3 = false;
	private boolean listBottemFlag = true;

	private View mCurView = null;
	
	private ShopAdapter mShopAdapter = null;
	private LoadImgUtil loadImgUtil;
	private List<Shop> shopLists = new ArrayList<Shop>();
	private MyJson myJson = new MyJson();
	
	private int mStart = 0;
	private int mEnd = 5;
	
	
	private static final String TAG = "SearchShops";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_search_shops);
		
		initView();
		setListen();
		setAdapter();
	}
	
	
	private void initView(){
		mBackImgBt = (ImageView)findViewById(R.id.back_img);
		mShopTitle = (TextView)findViewById(R.id.shop_list_title);
		mShoptitleImgBt = (ImageView)findViewById(R.id.shop_title_bt);
		mShoplistWholeCity = (TextView)findViewById(R.id.shoplist_title_wholecity);
		mShopListFood = (TextView)findViewById(R.id.Shoplist_title_food);
		mShopListDefaultSort = (TextView)findViewById(R.id.Shoplist_title_defaultsort);
		mShopListMain1 = (LinearLayout)findViewById(R.id.Shoplist_mainlist1);
		mShopListMain2 = (LinearLayout)findViewById(R.id.Shoplist_mainlist2);
		
		mShopMainListV = (ListView)findViewById(R.id.shopListView);
		mShopTopListV = (ListView)findViewById(R.id.shoplist_toplist);
		mShopDefaultSortV = (ListView)findViewById(R.id.shopListView);
		mShopClassfyListV = (ListView)findViewById(R.id.shopListView);
		mShopClassfyListV2 = (ListView)findViewById(R.id.shopListView);
		mShopAreaListV = (ListView)findViewById(R.id.shopListView);
		mShopAreaListV2 = (ListView)findViewById(R.id.shopListView);
		
		mShopTitle.setTag(R.id.shop_list_title);
		mShoptitleImgBt.setTag(R.id.shop_title_bt);
		mShoplistWholeCity.setTag(R.id.shoplist_title_wholecity);
		mShopListFood.setTag(R.id.Shoplist_title_food);
		mShopListDefaultSort.setTag(R.id.Shoplist_title_defaultsort);


	}
	
	private void setListen(){
		ClickListen listen = new ClickListen();
		mBackImgBt.setOnClickListener(listen);
		mShopTitle.setOnClickListener(listen);
		mShoptitleImgBt.setOnClickListener(listen);
		mShoplistWholeCity.setOnClickListener(listen);
		mShopListFood.setOnClickListener(listen);
		mShopListDefaultSort.setOnClickListener(listen);
	}
	
	private void setAdapter(){
		mShopAdapter = new ShopAdapter(this, shopLists);
		listBottomBt = new Button(this);
		listBottomBt.setText("下载更多");
		listBottomBt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(listBottemFlag){
					listBottemFlag = false;
					String url = IStaticVar.HTTPURL+IStaticVar.SHOPURL+"start="+mStart+"&end="+mEnd;
					ThreadPoolUtils.execute(new HttpGetThread(handler, url));
				}else{
					
				}
				
			}
		});
		
		mShopMainListV.addFooterView(listBottomBt, null, false);
		listBottomBt.setVisibility(View.INVISIBLE);
		mShopMainListV.setAdapter(mShopAdapter);
		String url = IStaticVar.HTTPURL+IStaticVar.SHOPURL+"start="+mStart+"&end="+mEnd;
		ThreadPoolUtils.execute(new HttpGetThread(handler, url));
		loadImgUtil = LoadImgUtil.getSingleInstance(this, IStaticVar.CACHE_DIR);
	}
	
	private Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			int what = msg.what;
			switch(what){
			case HttpStatus.SC_OK:
				String result = (String) msg.obj;
				Log.e(TAG, "result = "+result);
				getShopsFromJsonStr(result);
				break;
			case HttpStatus.SC_NOT_FOUND:
				listBottemFlag = true;
				break;
			case HttpStatus.SC_CONTINUE:
				listBottemFlag = true;
				break;
			}
		};
	};
	
	private void getShopsFromJsonStr(String json){
		if(json == null ||"".equals(json)){
			return;
		}
		
		List<Shop> newList = myJson.getShopList(json);
		if(newList != null){
			if(newList.size()==5){
				listBottomBt.setVisibility(View.VISIBLE);
				mStart += 5;
				mEnd += 5;
				listBottemFlag = true;
			}else{
				listBottomBt.setVisibility(View.INVISIBLE);
			}
			
			for(Shop shop:newList){
				shopLists.add(shop);
			}
		}
		mShopAdapter.notifyDataSetChanged();
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		loadImgUtil.flushDiskCache();
		super.onPause();
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		//loadImgUtil.closeDiskCache();
		super.onDestroy();
	}
	
	private class ClickListen implements View.OnClickListener{
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int id = v.getId();
			Drawable drawable = null;
			if(id == R.id.back_img){
				finish();
			}else if(id == R.id.shop_list_title || id == R.id.shop_title_bt){
				if(bDisTpListV){
					mShoptitleImgBt.setBackgroundResource(R.drawable.title_arrow_down_normal);
					bDisTpListV = false;
					
				}else{
					bDisTpListV = true;
					mShoptitleImgBt.setBackgroundResource(R.drawable.title_arrow_up);
					
				}
			}else {
				mShoptitleImgBt.setBackgroundResource(R.drawable.title_arrow_down_normal);
			}
			
			if(id == R.id.shoplist_title_wholecity){
				mShopListMain2.setVisibility(View.INVISIBLE);	
				drawable = getResources().getDrawable(
						R.drawable.ic_arrow_down_black);
				drawable.setBounds(0, 0, drawable.getMinimumWidth(),
						drawable.getMinimumHeight());
				mShopListFood.setCompoundDrawables(null,null,drawable,null);
				mShopListDefaultSort.setCompoundDrawables(null,null,drawable,null);
				mShopDefaultSortV.setVisibility(View.INVISIBLE);
				bDisTreeListV2 = false;
				bDisTreeListV3 = false;
				if(bDisTreeListV1){
					bDisTreeListV1 = false;
					drawable = getResources().getDrawable(
							R.drawable.ic_arrow_down_black);
					mShopListMain1.setVisibility(View.INVISIBLE);
					mShopMainListV.setVisibility(View.VISIBLE);
				}else{
					bDisTreeListV1 = true;
					drawable = getResources().getDrawable(
							R.drawable.ic_arrow_up_black);
					mShopListMain1.setVisibility(View.VISIBLE);
				}
				drawable.setBounds(0, 0, drawable.getMinimumWidth(),
						drawable.getMinimumHeight());	
				mShoplistWholeCity.setCompoundDrawables(null,null,drawable,null);
				
			}else if(id == R.id.Shoplist_title_food){
				mShopListMain1.setVisibility(View.INVISIBLE);
				drawable = getResources().getDrawable(
						R.drawable.ic_arrow_up_black);
				drawable.setBounds(0, 0, drawable.getMinimumWidth(),
						drawable.getMinimumHeight());
				mShoplistWholeCity.setCompoundDrawables(null,null,drawable,null);
				mShopListDefaultSort.setCompoundDrawables(null,null,drawable,null);
				mShopDefaultSortV.setVisibility(View.INVISIBLE);
				bDisTreeListV1 = false;
				bDisTreeListV3 = false;
				if(bDisTreeListV2){
					bDisTreeListV2 = false;
					drawable = getResources().getDrawable(
							R.drawable.ic_arrow_down_black);
					mShopListMain2.setVisibility(View.INVISIBLE);
					mShopMainListV.setVisibility(View.VISIBLE);
				}else{
					bDisTreeListV2 = true;
					drawable = getResources().getDrawable(
							R.drawable.ic_arrow_up_black);
				}
				
				drawable.setBounds(0, 0, drawable.getMinimumWidth(),
						drawable.getMinimumHeight());
				mShopListFood.setCompoundDrawables(null,null,drawable,null);
				
			}else if(id == R.id.Shoplist_title_defaultsort){
				bDisTreeListV1 = false;
				bDisTreeListV2 = false;
				mShopListMain1.setVisibility(View.INVISIBLE);
				mShopListMain2.setVisibility(View.INVISIBLE);
				drawable = getResources().getDrawable(
						R.drawable.ic_arrow_down_black);
				drawable.setBounds(0, 0, drawable.getMinimumWidth(),
						drawable.getMinimumHeight());
				mShoplistWholeCity.setCompoundDrawables(null,null,drawable,null);
				mShopListFood.setCompoundDrawables(null,null,drawable,null);
				if(bDisTreeListV3){
					bDisTreeListV3 = false;
					mShopMainListV.setVisibility(View.VISIBLE);
					drawable = getResources().getDrawable(
							R.drawable.ic_arrow_down_black);
				}else{
					bDisTreeListV3 = true;
					drawable = getResources().getDrawable(
							R.drawable.ic_arrow_up_black);
				}
				drawable.setBounds(0, 0, drawable.getMinimumWidth(),
						drawable.getMinimumHeight());
				mShopListDefaultSort.setCompoundDrawables(null,null,drawable,null);
			}else{
				bDisTreeListV1 = false;
				bDisTreeListV2 = false;
				bDisTreeListV3 = false;
				mShopListMain1.setVisibility(View.INVISIBLE);
				mShopListMain2.setVisibility(View.INVISIBLE);
				mShopDefaultSortV.setVisibility(View.INVISIBLE);
				drawable = getResources().getDrawable(
						R.drawable.ic_arrow_down_black);
				drawable.setBounds(0, 0, drawable.getMinimumWidth(),
						drawable.getMinimumHeight());
				mShoplistWholeCity.setCompoundDrawables(null,null,drawable,null);
				mShopListFood.setCompoundDrawables(null,null,drawable,null);
				mShopListDefaultSort.setCompoundDrawables(null,null,drawable,null);
				mShopMainListV.setVisibility(View.VISIBLE);
			}
			

		}
	}
}
