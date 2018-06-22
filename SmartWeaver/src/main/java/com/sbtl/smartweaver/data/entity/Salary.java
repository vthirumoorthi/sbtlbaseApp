package com.sbtl.smartweaver.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="EMP_SALARY")
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="BILL_ID")
    private long billid;
    @Column(name="BILL_DATE")
    private Date date;
    @Column(name="EMP_ID")
    private long empId;
    @Column(name="FACTORY_ID")
    private long factoryId;
    @Column(name="METRES_WEAVED")
    private float metresWeaved;
    @Column(name="AMOUNT_PAID")
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
	public void setMetresWeaved(float metresWeaved) {
		this.metresWeaved = metresWeaved;
	}
	public float getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(float amountPaid) {
		this.amountPaid = amountPaid;
	}


    
}
