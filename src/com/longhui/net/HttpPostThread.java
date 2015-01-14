package com.longhui.net;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;

import android.os.Handler;
import android.os.Message;

public class HttpPostThread implements Runnable {

	private Handler handler;
	private String url;
	private List<Parameter> parameters;
	private HttpMyPost myPost;
	public HttpPostThread(Handler handler, String url, List<Parameter> parameters) {
		// TODO Auto-generated constructor stub
		this.handler = handler;
		this.url = url;
		this.parameters = parameters;
		myPost = new HttpMyPost();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Message msg = handler.obtainMessage();
		try {
			String result = myPost.doPost(url, parameters);
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
