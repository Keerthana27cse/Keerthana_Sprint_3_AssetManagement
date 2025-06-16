package com.example.assetmanagement.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity 
public class AssetAudit { 
@Id 
@GeneratedValue(strategy = GenerationType.IDENTITY) 
private Long id; 
@ManyToOne 
private Employee employee; 
@ManyToOne 
private Asset asset; 
private String remarks; 
@Enumerated(EnumType.STRING) 
private RequestStatus status; 
private LocalDate auditDate;
public AssetAudit() {
	super();
	// TODO Auto-generated constructor stub
}
public AssetAudit(Long id, Employee employee, Asset asset, String remarks, RequestStatus status, LocalDate auditDate) {
	super();
	this.id = id;
	this.employee = employee;
	this.asset = asset;
	this.remarks = remarks;
	this.status = status;
	this.auditDate = auditDate;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Employee getEmployee() {
	return employee;
}
public void setEmployee(Employee employee) {
	this.employee = employee;
}
public Asset getAsset() {
	return asset;
}
public void setAsset(Asset asset) {
	this.asset = asset;
}
public String getRemarks() {
	return remarks;
}
public void setRemarks(String remarks) {
	this.remarks = remarks;
}
public RequestStatus getStatus() {
	return status;
}
public void setStatus(RequestStatus status) {
	this.status = status;
}
public LocalDate getAuditDate() {
	return auditDate;
}
public void setAuditDate(LocalDate auditDate) {
	this.auditDate = auditDate;
}
@Override
public String toString() {
	return "AssetAudit [id=" + id + ", employee=" + employee + ", asset=" + asset + ", remarks=" + remarks + ", status="
			+ status + ", auditDate=" + auditDate + "]";
}
}
