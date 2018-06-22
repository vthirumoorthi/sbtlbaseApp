package com.sbtl.smartweaver.data.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CLOTHSTOCK")
public class Stocking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pcId;
    @Column(name="LOOM_ID")
    private long loomId;
    @Column(name="EMP_ID")
    private long empId;
    @Column(name="ENTRY_DATE")
    private Date entryDate;
    @Column(name="METRES_WEAVED")
    private float meteresWeaved;
    @Column(name="TOTAL_METRES")
    private String totalMetres;
    @Column(name="SALARY_PROCESS")
    private String salProcessed;
    @Column(name="DELIVERY_PROCESS")
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
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	public String getProcessedState() {
		return processedState;
	}
	public void setProcessedState(String processedState) {
		this.processedState = processedState;
	}
	public String getSalProcessed() {
		return salProcessed;
	}
	public void setSalProcessed(String salProcessed) {
		this.salProcessed = salProcessed;
	}

   


}
