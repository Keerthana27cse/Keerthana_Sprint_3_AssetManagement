package com.example.assetmanagement.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.example.assetmanagement.enums.AssetStatus;

@Entity
@Table(name = "asset", uniqueConstraints = {
    @UniqueConstraint(columnNames = "asset_no")
})
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "asset_no", nullable = false, unique = true)
    private String assetNo;

    @Column(name = "asset_name", nullable = false)
    private String assetName;
    
    @Column(name = "asset_model")
    private String assetModel;

    @Column(name = "manufacturing_date")
    private LocalDate manufacturingDate;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @Column(name = "asset_value")
    private Double assetValue;

    @Enumerated(EnumType.STRING)
    @Column(name = "asset_status")
    private AssetStatus assetStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private AssetCategory category;
    
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

	public Asset() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Asset(Long id, String assetNo, String assetName, String assetModel, LocalDate manufacturingDate,
			LocalDate expiryDate, Double assetValue, AssetStatus assetStatus, AssetCategory category,
			LocalDateTime createdAt) {
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
		this.createdAt = createdAt;
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

	public void setAssetValue(Double assetValue) {
		this.assetValue = assetValue;
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Asset [id=" + id + ", assetNo=" + assetNo + ", assetName=" + assetName + ", assetModel=" + assetModel
				+ ", manufacturingDate=" + manufacturingDate + ", expiryDate=" + expiryDate + ", assetValue="
				+ assetValue + ", assetStatus=" + assetStatus + ", category=" + category + ", createdAt=" + createdAt
				+ "]";
	}
}
	
	

    
