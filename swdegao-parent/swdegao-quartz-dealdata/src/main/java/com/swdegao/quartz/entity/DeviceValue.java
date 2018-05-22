package com.swdegao.quartz.entity;

import java.util.Date;

public class DeviceValue {
	private Date Time;
	
	private DetailData Value;

	public Date getTime() {
		return Time;
	}

	public DetailData getValue() {
		return Value;
	}

	public void setTime(Date time) {
		Time = time;
	}

	public void setValue(DetailData value) {
		Value = value;
	}
	
	
}
