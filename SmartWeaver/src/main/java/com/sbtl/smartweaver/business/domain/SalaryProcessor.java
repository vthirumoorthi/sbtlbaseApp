package com.sbtl.smartweaver.business.domain;

import java.util.Date;


public class SalaryProcessor {
    private long billid;
    private Date date;
    private long empId;
    private long factoryId;
    private String empName;
    private String factoryName;
    private float metresWeaved;
    private float amountPaid;
	public long getBillid() {
		return billid;
	}
	public void setBillid(long billid) {
		this.billid = billid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public long getFactoryId() {
		return factoryId;
	}
	public void setFactoryId(long factoryId) {
		this.factoryId = factoryId;
	}
	public float getMetresWeaved() {
		return metresWeaved;
	}
	public void setMetresWeaved(float totalMetres) {
		this.metresWeaved = totalMetres;
	}
	public float getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(float amountPaid) {
		this.amountPaid = amountPaid;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getFactoryName() {
		return factoryName;
	}
	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}

  
}
