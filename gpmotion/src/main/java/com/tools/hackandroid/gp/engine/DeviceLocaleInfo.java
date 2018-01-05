package com.tools.hackandroid.gp.engine;


public class DeviceLocaleInfo
{
	public String mccmnc = "310026";
	public int mcc = 310;
	public int mnc = 026;
	public String operatorName = "T-Mobile";
	public String locale = "en_US";
	public int index = 232;
	public int countryCode = 01;
	
	public DeviceLocaleInfo(String mccmnc, int mcc, int mnc, String operatorName, String locale, int index, int countryCode)
	{
		this.mccmnc = mccmnc;
		this.mcc = mcc;
		this.mnc = mnc;
		this.operatorName = operatorName;
		this.locale = locale;
		this.index = index;
		this.countryCode = countryCode;
	}

}
