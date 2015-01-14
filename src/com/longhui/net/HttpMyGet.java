package com.longhui.net;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class HttpMyGet {
	public String doGet(String url)throws ClientProtocolException, IOException{
		String response = null; //返回信息
		HttpGet httpGet = new HttpGet(url);
		HttpParams httpParams = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParams, 5*1000);
		HttpConnectionParams.setSoTimeout(httpParams, 30*1000);
		HttpClient httpClient = new DefaultHttpClient(httpParams);
		HttpResponse res = httpClient.execute(httpGet);
		int statusCode = res.getStatusLine().getStatusCode();
		if(statusCode == HttpStatus.SC_OK){
			response = EntityUtils.toString(res.getEntity(),HTTP.UTF_8);
		}else{
			response = "返回码："+statusCode;
		}
		
		return response;
	}
}
