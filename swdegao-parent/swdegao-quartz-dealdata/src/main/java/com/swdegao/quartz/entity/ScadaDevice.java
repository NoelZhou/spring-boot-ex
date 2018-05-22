package com.swdegao.quartz.entity;

public class ScadaDevice {
	private int Id;
	private int UserTerminals;
	private String name;
	private String ModelName;
	private String Address;
	private String Pipe;
	private int PipeDN;
	private int Period;
	private String Status;
	private String NameFactory;
	private String DateBuild;
	private String CurrentTotalFlow;
	private String CurrentReadNumber;
	private String CurrentReverseNumber;
	private String CurrentPressure;
	private String CurrentElectromagneticPressure;
	private String CurrentTerminalVol;
	private String CurrentTerminalCSQ;
	private String CurrentReadDate;
	
	public String getCurrentTotalFlow() {
		return CurrentTotalFlow;
	}
	public String getCurrentReadNumber() {
		return CurrentReadNumber;
	}
	public String getCurrentReverseNumber() {
		return CurrentReverseNumber;
	}
	public String getCurrentPressure() {
		return CurrentPressure;
	}
	public String getCurrentElectromagneticPressure() {
		return CurrentElectromagneticPressure;
	}
	public String getCurrentTerminalVol() {
		return CurrentTerminalVol;
	}
	public String getCurrentTerminalCSQ() {
		return CurrentTerminalCSQ;
	}
	public String getCurrentReadDate() {
		return CurrentReadDate;
	}
	public void setCurrentTotalFlow(String currentTotalFlow) {
		CurrentTotalFlow = currentTotalFlow;
	}
	public void setCurrentReadNumber(String currentReadNumber) {
		CurrentReadNumber = currentReadNumber;
	}
	public void setCurrentReverseNumber(String currentReverseNumber) {
		CurrentReverseNumber = currentReverseNumber;
	}
	public void setCurrentPressure(String currentPressure) {
		CurrentPressure = currentPressure;
	}
	public void setCurrentElectromagneticPressure(String currentElectromagneticPressure) {
		CurrentElectromagneticPressure = currentElectromagneticPressure;
	}
	public void setCurrentTerminalVol(String currentTerminalVol) {
		CurrentTerminalVol = currentTerminalVol;
	}
	public void setCurrentTerminalCSQ(String currentTerminalCSQ) {
		CurrentTerminalCSQ = currentTerminalCSQ;
	}
	public void setCurrentReadDate(String currentReadDate) {
		CurrentReadDate = currentReadDate;
	}
	public int getId() {
		return Id;
	}
	public int getUserTerminals() {
		return UserTerminals;
	}
	public String getName() {
		return name;
	}
	public String getModelName() {
		return ModelName;
	}
	public String getAddress() {
		return Address;
	}
	public String getPipe() {
		return Pipe;
	}
	public int getPipeDN() {
		return PipeDN;
	}
	public int getPeriod() {
		return Period;
	}
	public String getStatus() {
		return Status;
	}
	public String getNameFactory() {
		return NameFactory;
	}
	public String getDateBuild() {
		return DateBuild;
	}
	public void setId(int id) {
		this.Id = id;
	}
	public void setUserTerminals(int userTerminals) {
		UserTerminals = userTerminals;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setModelName(String modelName) {
		ModelName = modelName;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public void setPipe(String pipe) {
		Pipe = pipe;
	}
	public void setPipeDN(int pipeDN) {
		PipeDN = pipeDN;
	}
	public void setPeriod(int period) {
		Period = period;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public void setNameFactory(String nameFactory) {
		NameFactory = nameFactory;
	}
	public void setDateBuild(String dateBuild) {
		DateBuild = dateBuild;
	}
	
}
