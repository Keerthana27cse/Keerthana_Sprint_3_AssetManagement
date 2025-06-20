package com.example.assetmanagement.model;

import java.time.LocalDate;

import com.example.assetmanagement.enums.RequestStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name = "new_asset_request")
public class NewAssetRequest { 
@Id 
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id; 
@ManyToOne 
private Employee employee; 
@ManyToOne 
private AssetCategory requestedCategory; 
private String description; 
@Enumerated(EnumType.STRING) 
private RequestStatus status =RequestStatus.PENDING;; 
private LocalDate requestDate;
public NewAssetRequest() {
	super();
	// TODO Auto-generated constructor stub
}
public NewAssetRequest(Long id, Employee employee, AssetCategory requestedCategory, String description,
		RequestStatus status, LocalDate requestDate) {
	super();
	this.id = id;
	this.employee = employee;
	this.requestedCategory = requestedCategory;
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
public Employee getEmployee() {
	return employee;
}
public void setEmployee(Employee employee) {
	this.employee = employee;
}
public AssetCategory getRequestedCategory() {
	return requestedCategory;
}
public void setRequestedCategory(AssetCategory requestedCategory) {
	this.requestedCategory = requestedCategory;
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
	return "NewAssetRequest [id=" + id + ", employee=" + employee + ", requestedCategory=" + requestedCategory
			+ ", description=" + description + ", status=" + status + ", requestDate=" + requestDate + "]";
}

} 
