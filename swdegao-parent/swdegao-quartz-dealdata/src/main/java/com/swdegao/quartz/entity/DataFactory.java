package com.swdegao.quartz.entity;

import java.util.Date;

/**
 * 计量漏损等监控表的实时数据
 * 水表实时数据中间表,针对有每隔几分钟一条数据的表.
 * @author zhoutao
 */
public class DataFactory {
	
	private String meter_id;//表id
	private String factory_no;//厂商代码
	private String meter_type;//水表类型
	private Date collectiondate;//抄表日期
	private double pressure;//压力
	private double flow;//瞬时流量
	private double ainterflow;//间隔流量
	private double pflownum;//正计流量
	private double cflownum;//反计流量
	private double residualchlorine;//余氯
	private double turbidity;//浊度
	private double salinity;//咸度
	private String power;//电量
	private String simno;//SIM卡号
	private String waterline;//水位
	private Double voltage;//电压
	private String datafrom;//数据来源
	private Date writetime;//写入日期
	public String getMeter_id() {
		return meter_id;
	}
	public String getFactory_no() {
		return factory_no;
	}
	public String getMeter_type() {
		return meter_type;
	}
	public Date getCollectiondate() {
		return collectiondate;
	}
	public double getPressure() {
		return pressure;
	}
	public double getFlow() {
		return flow;
	}
	public double getAinterflow() {
		return ainterflow;
	}
	public double getPflownum() {
		return pflownum;
	}
	public double getCflownum() {
		return cflownum;
	}
	public double getResidualchlorine() {
		return residualchlorine;
	}
	public double getTurbidity() {
		return turbidity;
	}
	public double getSalinity() {
		return salinity;
	}
	public String getPower() {
		return power;
	}
	public String getSimno() {
		return simno;
	}
	public String getWaterline() {
		return waterline;
	}
	public Double getVoltage() {
		return voltage;
	}
	public String getDatafrom() {
		return datafrom;
	}
	public Date getWritetime() {
		return writetime;
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
	public void setCollectiondate(Date collectiondate) {
		this.collectiondate = collectiondate;
	}
	public void setPressure(double pressure) {
		this.pressure = pressure;
	}
	public void setFlow(double flow) {
		this.flow = flow;
	}
	public void setAinterflow(double ainterflow) {
		this.ainterflow = ainterflow;
	}
	public void setPflownum(double pflownum) {
		this.pflownum = pflownum;
	}
	public void setCflownum(double cflownum) {
		this.cflownum = cflownum;
	}
	public void setResidualchlorine(double residualchlorine) {
		this.residualchlorine = residualchlorine;
	}
	public void setTurbidity(double turbidity) {
		this.turbidity = turbidity;
	}
	public void setSalinity(double salinity) {
		this.salinity = salinity;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public void setSimno(String simno) {
		this.simno = simno;
	}
	public void setWaterline(String waterline) {
		this.waterline = waterline;
	}
	public void setVoltage(Double voltage) {
		this.voltage = voltage;
	}
	public void setDatafrom(String datafrom) {
		this.datafrom = datafrom;
	}
	public void setWritetime(Date writetime) {
		this.writetime = writetime;
	}
	
}
