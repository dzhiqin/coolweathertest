package com.example.coolweathertest.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpUtil {
	public static void sendHttpRequest(final String address,final HttpCallbackListener listener){
		LogUtil.v("TAG","HttpUtil_sendHttpRequest()");
		LogUtil.v("TAG", "address="+address);
		new Thread(new Runnable(){

			@Override
			public void run() {			
				
				try {
					HttpClient httpClient=new DefaultHttpClient();
					HttpGet httpGet=new HttpGet(address);
					HttpResponse httpResponse=httpClient.execute(httpGet);
					if(httpResponse.getStatusLine().getStatusCode()==200){
						//请求和响应都成功了
						HttpEntity entity=httpResponse.getEntity();
						String response=EntityUtils.toString(entity,"utf-8");
						LogUtil.v("TAG","response="+response);
						if(listener!=null){
							listener.onFinish(response.toString());
						}
					}
				} catch (ClientProtocolException e) {
					if(listener!=null){
						listener.onError(e);
					}
				} catch (IOException e) {
					if(listener!=null){
						listener.onError(e);
					}
				}
				
			}
			
		}).start();
		/*new Thread(new Runnable(){

			@Override
			public void run() {
				HttpURLConnection connection=null;
				try{
					
					URL url=new URL(address);
					connection=(HttpURLConnection) url.openConnection();
					connection.setRequestMethod("GET");
					connection.setConnectTimeout(8000);
					connection.setReadTimeout(8000);
					
					InputStream in=connection.getInputStream();					
					BufferedReader reader=new BufferedReader (new InputStreamReader(in));	
					StringBuilder response=new StringBuilder();
					String line;
					while((line=reader.readLine())!=null){
						response.append(line);
					}
					LogUtil.v("TAG","response="+response);
					if(listener!=null){
						listener.onFinish(response.toString());
					}
				}catch(Exception e){
					if(listener!=null){
						listener.onError(e);
					}
				}finally{
					if(connection!=null){
						connection.disconnect();
					}
				}
				
			}
			
		}).start();*/
	}

}
