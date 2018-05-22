package com.swdegao.quartz.common;


public class URLConfig {
	
	/**
	 * 设备列表
	 */
	public static final String SCADA_DEVs = "http://121.40.63.15:8889/WebApi/GetScadaListForRealTime?Type=all&AreaID=51";
	
	/**
	 * 设备value
	 */
	public static final String SCADA_VALs = "http://121.40.63.15:8889/WebApi/GetScadaValueByUserTerminals?ids=%s";
	
	/**
	 * 设备value 带时间
	 */
	public static final String SCADA_VALs_TIME = "http://121.40.63.15:8889/WebApi/GetScadaValueByUserTerminals?ids=%s&TimeBeg=%s&TimeEnd=%s";
}
