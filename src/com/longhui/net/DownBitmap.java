package com.longhui.net;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class DownBitmap {
	
	public InputStream getInputStreamFromURL(String url) {
		HttpGet httpGet = new HttpGet(url);
		HttpParams httpParams = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParams, 5 * 1000);
		HttpConnectionParams.setSoTimeout(httpParams, 30 * 1000);
		HttpClient httpClient = new DefaultHttpClient(httpParams);
		try {
			HttpResponse res = httpClient.execute(httpGet);
			if (res.getStatusLine().getStatusCode() == 200) {
				return res.getEntity().getContent();
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
