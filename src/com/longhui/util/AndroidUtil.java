package com.longhui.util;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.view.View;

/**
 * 用于设置屏幕风格的工具类
 * @author zhonglh
 *
 */
public class AndroidUtil {
	
	/**
	 * 判断是否连接网络
	 * @param ctx
	 * @return
	 */
	public static boolean IsConnect(Context ctx) {
		ConnectivityManager manager = (ConnectivityManager) ctx
				.getSystemService(ctx.CONNECTIVITY_SERVICE);
		NetworkInfo info = manager
				.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		State stata = null;
		if (info != null) {
			stata = info.getState();
			if (stata == State.CONNECTED)
				return true;
		}
		info = null;
		info = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		stata = null;
		if (info != null) {
			stata = info.getState();
			if (stata == State.CONNECTED) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 判断android系统是否安装某个程序包名
	 * @param context
	 * @param packageName
	 * @return
	 */
	public static boolean isAvilible(Context context, String packageName) {
		final PackageManager packageManager = context.getPackageManager();// 获取packagemanager
		List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);// 获取所有已安装程序的包信息
		List<String> pName = new ArrayList<String>();// 用于存储所有已安装程序的包名
		// 从pinfo中将包名字逐一取出，压入pName list中
		if (pinfo != null) {
			for (int i = 0; i < pinfo.size(); i++) {
				String pn = pinfo.get(i).packageName;
				pName.add(pn);
			}
		}
		return pName.contains(packageName);// 判断pName中是否有目标程序的包名，有TRUE，没有FALSE
	}
	
	/**
	 * 屏蔽掉系统底部导航栏
	 * @param activity
	 */
	public static void setFullScreen(Activity activity){
		
		View view = activity.getWindow().getDecorView();
//		view.setSystemUiVisibility(8);
		view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
				| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
				| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
				| View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
				| View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
//				| View.SYSTEM_UI_FLAG_IMMERSIVE
				| View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
				);
		
	}
}
