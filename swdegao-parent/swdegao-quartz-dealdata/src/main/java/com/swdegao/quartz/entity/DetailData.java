package com.swdegao.quartz.entity;

public class DetailData {
	
	private Double TotalFlow;
	private Double ReadNumber;
	private Double ReverseNumber;
	private Double Pressure;
	public Double getTotalFlow() {
		return TotalFlow;
	}
	public Double getReadNumber() {
		return ReadNumber;
	}
	public Double getReverseNumber() {
		return ReverseNumber;
	}
	public Double getPressure() {
		return Pressure;
	}
	public void setTotalFlow(Double totalFlow) {
		TotalFlow = totalFlow;
	}
	public void setReadNumber(Double readNumber) {
		ReadNumber = readNumber;
	}
	public void setReverseNumber(Double reverseNumber) {
		ReverseNumber = reverseNumber;
	}
	public void setPressure(Double pressure) {
		Pressure = pressure;
	}
	
}
