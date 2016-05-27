package com.example.coolweathertest.activity;

import java.util.ArrayList;
import java.util.List;

import com.example.coolweathertest.R;
import com.example.coolweathertest.db.CoolWeatherDB;
import com.example.coolweathertest.model.City;
import com.example.coolweathertest.model.County;
import com.example.coolweathertest.model.Province;





import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ChooseAreaActivity extends Activity {

	public static final int LEVEL_PROVINCE=0;
	public static final int LEVEL_CITY=0;
	public static final int LEVEL_COUNTY=0;
	private ProgressDialog progressDialog;
	private TextView titleText;
	private ListView listView;
	private ArrayAdapter<String> adapter;
	private CoolWeatherDB coolWeatherDB;
	private List<String> dataList=new ArrayList<String>();
	//省列表
	private List<Province> provinceList;
	//市列表
	private List<City> cityList;
	//县列表
	private List<County> countyList;
	//选中的省份
	private Province selectedProvince;
	//选中的城市
	private City selectedCity;
	//当前选中的级别
	private int currentLevel;
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.choose_area);
		listView=(ListView)findViewById(R.id.list_view);
		titleText=(TextView)findViewById(R.id.title_text);
		adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dataList);
		listView.setAdapter(adapter);
		coolWeatherDB=CoolWeatherDB.getInstance(this);
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				if(currentLevel==LEVEL_PROVINCE){
					selectedProvince=
				}
			}
		});
	}
}
