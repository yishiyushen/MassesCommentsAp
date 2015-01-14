package com.longhui.massescommentsap;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class StartActivity extends Activity {

	private boolean bFirstRun;
	private static final String FIRST_RUN = "first_run";
	
	private Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			gotoMain();
		};
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		Message msg = handler.obtainMessage();
		handler.sendMessageDelayed(msg, 1000);
	}
	
	private void gotoMain(){
		
		if(judgeFirstRun()){
			Intent intent = new Intent(this, LeadModeActivity.class);
			startActivity(intent);
		}else{
			Intent intent = new Intent(this, MainFrameActivity.class);
			startActivity(intent);
		}
		finish();
	}
	

	
	private boolean judgeFirstRun(){
		SharedPreferences preferences = this.getPreferences(Activity.MODE_PRIVATE);
		Editor editor = preferences.edit();
		boolean bFlag = preferences.getBoolean(FIRST_RUN, true);
		if(bFlag){
			editor.putBoolean(FIRST_RUN, false);
		}
		return bFlag;
	}
}
