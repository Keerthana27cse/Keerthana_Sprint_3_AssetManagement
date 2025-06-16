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
public class ServiceRequest { 
@Id 
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id; 
@ManyToOne 
private Asset asset; 
@ManyToOne 
private Employee employee; 
@Enumerated(EnumType.STRING) 
private IssueType issueType; 
private String description; 
@Enumerated(EnumType.STRING) 
private RequestStatus status; 
private LocalDate requestDate;
public ServiceRequest() {
	super();
	// TODO Auto-generated constructor stub
}
public ServiceRequest(Long id, Asset asset, Employee employee, IssueType issueType, String description,
		RequestStatus status, LocalDate requestDate) {
	super();
	this.id = id;
	this.asset = asset;
	this.employee = employee;
	this.issueType = issueType;
	this.description = description;
	this.status = status;
	this.requestDate = requestDate;
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
public IssueType getIssueType() {
	return issueType;
}
public void setIssueType(IssueType issueType) {
	this.issueType = issueType;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public RequestStatus getStatus() {
	return status;
}
public void setStatus(RequestStatus status) {
	this.status = status;
}
public LocalDate getRequestDate() {
	return requestDate;
}
public void setRequestDate(LocalDate requestDate) {
	this.requestDate = requestDate;
}
@Override
public String toString() {
	return "ServiceRequest [id=" + id + ", asset=" + asset + ", employee=" + employee + ", issueType=" + issueType
			+ ", description=" + description + ", status=" + status + ", requestDate=" + requestDate + "]";
} 

} 
