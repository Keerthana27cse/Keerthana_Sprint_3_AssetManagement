package com.example.assetmanagement.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity 
public class AssetAllocation { 
@Id 
@GeneratedValue(strategy = GenerationType.IDENTITY) 
private Long id; 
@ManyToOne 
private Asset asset; //id  10 to emp a on jan,then to emp b on dec-> one laptop may be allocated multimes to differ emp or diff time
@ManyToOne 
private Employee employee; //many allocation to one emp
private LocalDate allocationDate; 
private LocalDate returnDate;
public AssetAllocation() {
	super();
	// TODO Auto-generated constructor stub
}
public AssetAllocation(Long id, Asset asset, Employee employee, LocalDate allocationDate, LocalDate returnDate) {
	super();
	this.id = id;
	this.asset = asset;
	this.employee = employee;
	this.allocationDate = allocationDate;
	this.returnDate = returnDate;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Asset getAsset() {
	return asset;
}
public void setAsset(Asset asset) {
	this.asset = asset;
}
public Employee getEmployee() {
	return employee;
}
public void setEmployee(Employee employee) {
	this.employee = employee;
}
public LocalDate getAllocationDate() {
	return allocationDate;
}
public void setAllocationDate(LocalDate allocationDate) {
	this.allocationDate = allocationDate;
}
public LocalDate getReturnDate() {
	return returnDate;
}
public void setReturnDate(LocalDate returnDate) {
	this.returnDate = returnDate;
}
@Override
public String toString() {
	return "AssetAllocation [id=" + id + ", asset=" + asset + ", employee=" + employee + ", allocationDate="
			+ allocationDate + ", returnDate=" + returnDate + "]";
}
}
