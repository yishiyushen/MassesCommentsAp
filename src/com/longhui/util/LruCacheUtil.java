package com.longhui.util;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
/**
 * 内存缓存工具类
 * @author zhonglh
 *
 * @param <T>
 */
public class LruCacheUtil<T> {
	private LruCache<String, T> mMemoryCache;
	public LruCacheUtil() {
		// TODO Auto-generated constructor stub
		int maxMemory = (int)Runtime.getRuntime().maxMemory();
		int cacheSize= maxMemory/8;
		mMemoryCache = new LruCache<String, T>(cacheSize);
	}
	
	public void clearCache(){
		if(mMemoryCache == null){
			return;
		}
		
		if(mMemoryCache.size()>0){
			mMemoryCache.evictAll();
		}
	}
	
	public synchronized void addBitmapToMemoryCache(String key,T bitmap){
		if(mMemoryCache.get(key)==null){
			if(key != null && bitmap != null){
				mMemoryCache.put(key, bitmap);
			}
		}
	}
	
	public synchronized T getBitmapFromMemoryCache(String key){
		T bitmap = null;
		if(key != null){
			bitmap = mMemoryCache.get(key);
		}
		return bitmap;
	}
	
	
	public synchronized void removeBitmapCache(String key){
		if(key != null){
			mMemoryCache.remove(key);
		}
	}
}
