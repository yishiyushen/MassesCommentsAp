package com.longhui.adapter;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.longhui.massescommentsap.IStaticVar;
import com.longhui.massescommentsap.R;
import com.longhui.util.LoadImgUtil;
import com.longhui.util.LoadImgUtil.ImageDownloadCallBack;
import com.longhui.vo.Shop;

public class ShopAdapter extends BaseAdapter {
	private List<Shop> shopLists;
	private LayoutInflater inflater;
	private Context context;
	private LoadImgUtil loadImgUtil;
	
	public ShopAdapter(Context context, List<Shop> list) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.inflater = LayoutInflater.from(context);
		shopLists = list;
		loadImgUtil = LoadImgUtil.getSingleInstance(context, IStaticVar.CACHE_DIR);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return shopLists.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return shopLists.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final Holder hold;
		if(convertView == null){
			hold = new Holder();
			convertView = inflater.inflate(R.layout.item_shop, null);
			hold.mTitle = (TextView) convertView.findViewById(R.id.ShopItemTextView);
			hold.mImage = (ImageView) convertView.findViewById(R.id.ShopItemImage);
			hold.mMoney = (TextView) convertView.findViewById(R.id.ShopItemMoney);
			hold.mAddress = (TextView) convertView.findViewById(R.id.ShopItemAddress);
			hold.mStytle = (TextView) convertView.findViewById(R.id.ShopItemStytle);
			hold.mStar = (ImageView) convertView.findViewById(R.id.ShopItemStar);
			hold.mTuan = (ImageView) convertView.findViewById(R.id.ShopItemTuan);
			hold.mQuan = (ImageView) convertView.findViewById(R.id.ShopItemQuan);
			hold.mDing = (ImageView) convertView.findViewById(R.id.ShopItemDing);
			hold.mCard = (ImageView) convertView.findViewById(R.id.ShopItemCard);

			convertView.setTag(hold);
		}else{
			hold = (Holder) convertView.getTag();
		}
		
		hold.mTitle.setText(shopLists.get(position).getSname());
		hold.mImage.setTag(IStaticVar.SHOPLISTIMGURL + shopLists.get(position).getIname());
		hold.mMoney.setText(shopLists.get(position).getSmoney());
		hold.mAddress.setText(shopLists.get(position).getSaddress());
		hold.mStytle.setText(shopLists.get(position).getStype());
		hold.mTuan.setVisibility(View.GONE);
		hold.mQuan.setVisibility(View.GONE);
		hold.mDing.setVisibility(View.GONE);
		hold.mCard.setVisibility(View.GONE);
		if (shopLists.get(position).getSflag_tuan().equals("1")) {
			hold.mTuan.setVisibility(View.VISIBLE);
		}
		if (shopLists.get(position).getSflag_quan().equals("1")) {
			hold.mQuan.setVisibility(View.VISIBLE);
		}
		if (shopLists.get(position).getSflag_ding().equals("1")) {
			hold.mDing.setVisibility(View.VISIBLE);
		}
		if (shopLists.get(position).getSflag_ka().equals("1")) {
			hold.mCard.setVisibility(View.VISIBLE);
		}

		int slevel = Integer.valueOf(shopLists.get(position).getSlevel());
		switch (slevel) {
		case 0:
			hold.mStar.setImageResource(R.drawable.star0);
			break;
		case 1:
			hold.mStar.setImageResource(R.drawable.star1);
			break;
		case 2:
			hold.mStar.setImageResource(R.drawable.star2);
			break;
		case 3:
			hold.mStar.setImageResource(R.drawable.star3);
			break;
		case 4:
			hold.mStar.setImageResource(R.drawable.star4);
			break;
		case 5:
			hold.mStar.setImageResource(R.drawable.star5);
			break;
		}

		hold.mImage.setImageResource(R.drawable.shop_photo_frame);
		
		Bitmap bitmap = loadImgUtil.loadImage(hold.mImage, IStaticVar.SHOPLISTIMGURL + shopLists.get(position).getIname(), 
				new ImageDownloadCallBack() {
					
					@Override
					public void onImageDownload(ImageView imageview, Bitmap bitmap) {
						// TODO Auto-generated method stub
						if(hold.mImage.getTag().equals(IStaticVar.SHOPLISTIMGURL + shopLists.get(position).getIname())){
							hold.mImage.setImageBitmap(bitmap);
							hold.mImage.invalidate();
						}
					}
				});
		
		if(bitmap != null){
			hold.mImage.setImageBitmap(bitmap);
			hold.mImage.invalidate();
		}
		return convertView;
	}
	
	static class Holder {
		TextView mTitle, mMoney, mAddress, mStytle;
		ImageView mImage, mStar, mTuan, mQuan, mDing, mCard;
	}

}
