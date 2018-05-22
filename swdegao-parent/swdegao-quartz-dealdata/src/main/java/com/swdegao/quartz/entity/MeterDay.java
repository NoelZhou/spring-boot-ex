package com.swdegao.quartz.entity;

import java.util.Date;

/**
 * 贸易结算水表的日结数据表,每个表每天一条.
 * @author zhoutao
 */
public class MeterDay {
	
	private String meter_id;//表id
	private String factory_no;//厂商代码
	private String meter_type;//水表类型
	private Date freeze_date;//日结时间
	private double meter_num;//表底
	private int valve;//水表阀门状态
	private Date writetime;//写入时间
	private String meterstatus;//设备状态(JSON字符串)
	private String datafrom;//数据来源
	public String getMeter_id() {
		return meter_id;
	}
	public String getFactory_no() {
		return factory_no;
	}
	public String getMeter_type() {
		return meter_type;
	}
	public Date getFreeze_date() {
		return freeze_date;
	}
	public double getMeter_num() {
		return meter_num;
	}
	public int getValve() {
		return valve;
	}
	public Date getWritetime() {
		return writetime;
	}
	public String getMeterstatus() {
		return meterstatus;
	}
	public String getDatafrom() {
		return datafrom;
	}
	public void setMeter_id(String meter_id) {
		this.meter_id = meter_id;
	}
	public void setFactory_no(String factory_no) {
		this.factory_no = factory_no;
	}
	public void setMeter_type(String meter_type) {
		this.meter_type = meter_type;
	}
	public void setFreeze_date(Date freeze_date) {
		this.freeze_date = freeze_date;
	}
	public void setMeter_num(double meter_num) {
		this.meter_num = meter_num;
	}
	public void setValve(int valve) {
		this.valve = valve;
	}
	public void setWritetime(Date writetime) {
		this.writetime = writetime;
	}
	public void setMeterstatus(String meterstatus) {
		this.meterstatus = meterstatus;
	}
	public void setDatafrom(String datafrom) {
		this.datafrom = datafrom;
	}
	
}
