package com.longhui.net;

import java.io.IOException;

import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.protocol.HTTP;

import android.os.Handler;
import android.os.Message;

public class HttpGetThread implements Runnable {

	private Handler handler;
	private String url;
	private HttpMyGet myGet;
	
	public HttpGetThread(Handler handler, String url) {
		// TODO Auto-generated constructor stub
		this.handler = handler;
		this.url = url;
		myGet = new HttpMyGet();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Message msg = handler.obtainMessage();
		try {
			String result = myGet.doGet(url);
			msg.what = HttpStatus.SC_OK;
			msg.obj = result;
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			msg.what = HttpStatus.SC_NOT_FOUND;
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			msg.what = HttpStatus.SC_CONTINUE;
			e.printStackTrace();
		}
		
		handler.sendMessage(msg);
	}

}
