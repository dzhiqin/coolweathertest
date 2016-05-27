package com.example.coolweathertest.util;

public interface HttpCallbackListener {

	void onFinish(String string);

	void onError(Exception e);

}
