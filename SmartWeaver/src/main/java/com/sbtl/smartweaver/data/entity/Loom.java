package com.sbtl.smartweaver.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="LOOM")
public class Loom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="LOOM_ID")
    private long loomId;
    @Column(name="NAME")
    private String name;
    @Column(name="FACTORY_ID")
    private long factoryId;
	public long getLoomId() {
		return loomId;
	}
	public void setLoomId(long loomId) {
		this.loomId = loomId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getFactoryId() {
		return factoryId;
	}
	public void setFactoryId(long factoryId) {
		this.factoryId = factoryId;
	}
    
    
    
}