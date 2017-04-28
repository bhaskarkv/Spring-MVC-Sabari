package com.balaji.logistics.model;

public class Logistics {

	private int logisticId;
	private String logisticName;
	private float logisticRange;
	
	
	public Logistics(int logisticId, String logisticName, float logisticRange) {
		super();
		this.logisticId = logisticId;
		this.logisticName = logisticName;
		this.logisticRange = logisticRange;
	}
	
	public int getLogisticId() {
		return logisticId;
	}
	public void setLogisticId(int logisticId) {
		this.logisticId = logisticId;
	}
	public String getLogisticName() {
		return logisticName;
	}
	public void setLogisticName(String logisticName) {
		this.logisticName = logisticName;
	}
	public float getLogisticRange() {
		return logisticRange;
	}
	public void setLogisticRange(float logisticRange) {
		this.logisticRange = logisticRange;
	}
	
	
	
}
