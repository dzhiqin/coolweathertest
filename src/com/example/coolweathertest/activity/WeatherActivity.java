package com.example.coolweathertest.activity;


import com.example.coolweathertest.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WeatherActivity extends Activity {

	private LinearLayout weatherInfoLayout;
	//用于显示城市名
	private TextView cityNameText;
	//发布时间
	private TextView publishText;
	//天气描述信息
	private TextView weatherDespText;
	//气温
	private TextView temp1Text;
	private TextView temp2Text;
	//用于显示当前日期
	private TextView currentDateText;
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.weather_layout);
	}
}
