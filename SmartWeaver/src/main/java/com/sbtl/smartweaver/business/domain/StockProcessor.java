
package com.sbtl.smartweaver.business.domain;


public class StockProcessor {
    private long pcId;
    private long loomId;
    private long empId;
    private String empName;
    private long entryDate;
    private float meteresWeaved;
    private String totalMetres;
    private String processedState;
    
	public long getPcId() {
		return pcId;
	}
	public void setPcId(long pcId) {
		this.pcId = pcId;
	}
	public long getLoomId() {
		return loomId;
	}
	public void setLoomId(long loomId) {
		this.loomId = loomId;
	}
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public float getMeteresWeaved() {
		return meteresWeaved;
	}
	public void setMeteresWeaved(float meteresWeaved) {
		this.meteresWeaved = meteresWeaved;
	}
	public String getTotalMetres() {
		return totalMetres;
	}
	public void setTotalMetres(String totalMetres) {
		this.totalMetres = totalMetres;
	}
	public long getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(long entryDate) {
		this.entryDate = entryDate;
	}
	public String getProcessedState() {
		return processedState;
	}
	public void setProcessedState(String processedState) {
		this.processedState = processedState;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}

   


}
