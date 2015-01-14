package com.longhui.util;

import java.io.File;

import android.content.Context;
import android.os.Environment;

/**
 * 文件工具类
 * @author zhonglh
 *
 */
public class FileUtil {
	
	public static File getDiskCacheDir(Context context,String uniqueName){
		String cachePath = null;
		if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
				|| !Environment.isExternalStorageRemovable()){
			cachePath = context.getExternalCacheDir().getPath();
		}else{
			cachePath = context.getCacheDir().getPath();
		}
		
		return new File(cachePath+File.separator+uniqueName);
	}
	
	
}
