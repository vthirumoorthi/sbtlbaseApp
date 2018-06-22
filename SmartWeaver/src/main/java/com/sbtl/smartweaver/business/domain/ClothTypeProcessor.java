package com.sbtl.smartweaver.business.domain;


public class ClothTypeProcessor {
	private long clothId;
    private String name;
    private String pcDesc;
    private String status;
    
	public long getClothId() {
		return clothId;
	}
	public void setClothId(long clothId) {
		this.clothId = clothId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPcDesc() {
		return pcDesc;
	}
	public void setPcDesc(String pcDesc) {
		this.pcDesc = pcDesc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
