package com.sbtl.smartweaver.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="CLOTHTYPE")
public class ClothType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="CLOTH_ID")
    private long clothId;
    @Column(name="NAME")
    private String name;
    @Column(name="PC_DESCRIPTION")
    private String pcDesc;
    @Column(name="STATUS")
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