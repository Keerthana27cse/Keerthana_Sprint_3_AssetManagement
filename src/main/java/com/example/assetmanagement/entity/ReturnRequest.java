package com.example.assetmanagement.entity;

import java.time.LocalDateTime;

import com.example.assetmanagement.enums.RequestStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity 
public class ReturnRequest { 
@Id 
@GeneratedValue(strategy = GenerationType.IDENTITY) 
private Long id; 
@ManyToOne 
private Employee employee; 
@ManyToOne 
private Asset asset; 
private String reason; 
@Enumerated(EnumType.STRING) 
private RequestStatus status; 
private LocalDateTime requestDate;

private LocalDateTime returnDate;

public ReturnRequest() {
	super();
	// TODO Auto-generated constructor stub
}

public ReturnRequest(Long id, Employee employee, Asset asset, String reason, RequestStatus status,
		LocalDateTime requestDate, LocalDateTime returnDate) {
	super();
	this.id = id;
	this.employee = employee;
	this.asset = asset;
	this.reason = reason;
	this.status = status;
	this.requestDate = requestDate;
	this.returnDate = returnDate;
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

public String getReason() {
	return reason;
}

public void setReason(String reason) {
	this.reason = reason;
}

public RequestStatus getStatus() {
	return status;
}

public void setStatus(RequestStatus status) {
	this.status = status;
}

public LocalDateTime getRequestDate() {
	return requestDate;
}

public void setRequestDate(LocalDateTime requestDate) {
	this.requestDate = requestDate;
}

public LocalDateTime getReturnDate() {
	return returnDate;
}

public void setReturnDate(LocalDateTime returnDate) {
	this.returnDate = returnDate;
}

@Override
public String toString() {
	return "ReturnRequest [id=" + id + ", employee=" + employee + ", asset=" + asset + ", reason=" + reason
			+ ", status=" + status + ", requestDate=" + requestDate + ", returnDate=" + returnDate + "]";
}
}
