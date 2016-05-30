package com.example.coolweathertest.util;

import android.text.TextUtils;

import com.example.coolweathertest.db.CoolWeatherDB;
import com.example.coolweathertest.model.City;
import com.example.coolweathertest.model.County;
import com.example.coolweathertest.model.Province;

public class Utility {
	//������������ص�ʡ������
	public synchronized static boolean handleProvincesResponse(CoolWeatherDB coolWeatherDB,String response){
		LogUtil.d("TAG", "handleProvincesResponse()");
		if(!TextUtils.isEmpty(response)){
			String[] allProvinces=response.split(",");
			if(allProvinces!=null&&allProvinces.length>0){
				for(String p:allProvinces){
					String[] array=p.split("\\|");
					Province province=new Province();
					province.setProvinceCode(array[0]);
					province.setProvinceName(array[1]);
					//���������������ݴ洢��province�б�
					coolWeatherDB.saveProvince(province);
				}
				return true;
			}
		}
		return false;
		
	}

	//������������ص��м�����
	public  static boolean handleCitiesResponse(CoolWeatherDB coolWeatherDB,String response,int provinceId){
		LogUtil.d("TAG", "handleCitiesResponse()");
		if(!TextUtils.isEmpty(response)){
			String[] allCities=response.split(",");
			if(allCities!=null&&allCities.length>0){
				for(String c:allCities){
					String[] array=c.split("\\|");
					City city=new City();
					city.setCityCode(array[0]);
					city.setCityName(array[1]);
					city.setProvinceId(provinceId);
					coolWeatherDB.saveCity(city);
				}
				return true;
			}
		}
		return false;
	}
	
	//������������ص��ؼ�����
	public static boolean handleCountiesResponse(CoolWeatherDB coolWeatherDB,String response,int cityId){
		LogUtil.d("TAG", "handleCountiesResponse()");
		if(!TextUtils.isEmpty(response)){
			String[] allCounties=response.split(",");
			if(allCounties!=null&&allCounties.length>0){
				for(String c:allCounties){
					String[] array=c.split("\\|");
					County county=new County();
					county.setCountyCode(array[0]);
					county.setCountyName(array[1]);
					county.setCityId(cityId);
					//���������������ݴ洢�����ݿ�
					coolWeatherDB.saveCounty(county);
				}
				return true;
			}
		}
		return false;
	}
}
