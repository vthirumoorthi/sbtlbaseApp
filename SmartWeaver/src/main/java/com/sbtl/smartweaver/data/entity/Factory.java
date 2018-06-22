package com.sbtl.smartweaver.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="FACTORY")
public class Factory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="FACTORY_ID")
    private long factoryId;
    @Column(name="NAME")
    private String name;
    @Column(name="ADDRESS")
    private String address;
    /*@Column(name="STATUS")
    private String status;*/
	
	public long getFactoryId() {
		return factoryId;
	}
	public void setFactoryId(long factoryId) {
		this.factoryId = factoryId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/*public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}*/

    
}