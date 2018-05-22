package com.swdegao.quartz.entity;


import java.util.List;

public class ScadaDeviceValues {
	
	private int Id;
	private String Name;
	private String Type;
	private String Address;
	private List<DeviceValue> Data;
	public int getId() {
		return Id;
	}
	public String getName() {
		return Name;
	}
	public String getType() {
		return Type;
	}
	public String getAddress() {
		return Address;
	}
	public List<DeviceValue> getData() {
		return Data;
	}
	public void setId(int id) {
		Id = id;
	}
	public void setName(String name) {
		Name = name;
	}
	public void setType(String type) {
		Type = type;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public void setData(List<DeviceValue> data) {
		Data = data;
	}
	
	     
}
