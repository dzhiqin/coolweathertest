package com.example.coolweathertest.activity;


import com.example.coolweathertest.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WeatherActivity extends Activity {

	private LinearLayout weatherInfoLayout;
	//������ʾ������
	private TextView cityNameText;
	//����ʱ��
	private TextView publishText;
	//����������Ϣ
	private TextView weatherDespText;
	//����
	private TextView temp1Text;
	private TextView temp2Text;
	//������ʾ��ǰ����
	private TextView currentDateText;
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.weather_layout);
	}
}
