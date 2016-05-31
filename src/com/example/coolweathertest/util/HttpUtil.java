package com.example.coolweathertest.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {
	public static void sendHttpRequest(final String address,final HttpCallbackListener listener){
		LogUtil.v("TAG","HttpUtil_sendHttpRequest()");
		LogUtil.v("TAG", "address="+address);
		new Thread(new Runnable(){

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
					LogUtil.v("TAG", "sendRequest_newThreadrun()1");
					BufferedReader reader=new BufferedReader (new InputStreamReader(in));
					LogUtil.v("TAG", "sendRequest_newThreadrun(2)");
					StringBuilder response=new StringBuilder();
					LogUtil.v("TAG", "sendRequest_newThreadrun(3)");
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
			
		}).start();
	}

}
