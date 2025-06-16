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
public class Asset {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id; 
	private String assetNo; 
	private String assetName; 
	private String assetModel; 
	private LocalDate manufacturingDate; 
	private LocalDate expiryDate; 
	private Double assetValue; 
	@Enumerated(EnumType.STRING) 
	private AssetStatus assetStatus; 
	@ManyToOne
	private AssetCategory category;//id->//ph,com->electonics
	public Asset() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAssetNo() {
		return assetNo;
	}
	public void setAssetNo(String assetNo) {
		this.assetNo = assetNo;
	}
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public String getAssetModel() {
		return assetModel;
	}
	public void setAssetModel(String assetModel) {
		this.assetModel = assetModel;
	}
	public LocalDate getManufacturingDate() {
		return manufacturingDate;
	}
	public void setManufacturingDate(LocalDate manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Double getAssetValue() {
		return assetValue;
	}
	public void setAssetValue (Double f) {
		this.assetValue = f;
	}
	public AssetStatus getAssetStatus() {
		return assetStatus;
	}
	public void setAssetStatus(AssetStatus assetStatus) {
		this.assetStatus = assetStatus;
	}
	public AssetCategory getCategory() {
		return category;
	}
	public void setCategory(AssetCategory category) {
		this.category = category;
	}
	public Asset(Long id, String assetNo, String assetName, String assetModel, LocalDate manufacturingDate,
			LocalDate expiryDate, Double assetValue, AssetStatus assetStatus, AssetCategory category) {
		super();
		this.id = id;
		this.assetNo = assetNo;
		this.assetName = assetName;
		this.assetModel = assetModel;
		this.manufacturingDate = manufacturingDate;
		this.expiryDate = expiryDate;
		this.assetValue = assetValue;
		this.assetStatus = assetStatus;
		this.category = category;
	}
	@Override
	public String toString() {
		return "Asset [id=" + id + ", assetNo=" + assetNo + ", assetName=" + assetName + ", assetModel=" + assetModel
				+ ", manufacturingDate=" + manufacturingDate + ", expiryDate=" + expiryDate + ", assetValue="
				+ assetValue + ", assetStatus=" + assetStatus + ", category=" + category + "]";
	}
	
	} 

