package com.example.assetmanagement.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.example.assetmanagement.enums.RequestStatus;

@Entity(name = "new_asset_request")
public class NewAssetRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private AssetCategory requestedCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asset_id") // nullable, because user might request a new one not yet in system
    private Asset asset;

    @Column(length = 1000)
    private String description;

    @Column(columnDefinition = "TEXT",nullable=false)
    private String requestReason;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RequestStatus status = RequestStatus.PENDING;
    
    
    @Column(name = "request_date", nullable = false)
    private LocalDateTime requestDate;
	
    
 // Shipping details
    @Column(name = "address_line1", nullable = false, length = 100)
    private String fullAddress;

    @Column(name = "zip_code", nullable = false, length = 10)
    private String zipCode;

    @Column(length = 15)
    private String phone;
    
    public NewAssetRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewAssetRequest(Long id, Employee employee, AssetCategory requestedCategory, Asset asset, String description,
			String requestReason, RequestStatus status, LocalDateTime requestDate, String fullAddress, String zipCode,
			String phone) {
		super();
		this.id = id;
		this.employee = employee;
		this.requestedCategory = requestedCategory;
		this.asset = asset;
		this.description = description;
		this.requestReason = requestReason;
		this.status = status;
		this.requestDate = requestDate;
		this.fullAddress = fullAddress;
		this.zipCode = zipCode;
		this.phone = phone;
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

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRequestReason() {
		return requestReason;
	}

	public void setRequestReason(String requestReason) {
		this.requestReason = requestReason;
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

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "NewAssetRequest [id=" + id + ", employee=" + employee + ", requestedCategory=" + requestedCategory
				+ ", asset=" + asset + ", description=" + description + ", requestReason=" + requestReason + ", status="
				+ status + ", requestDate=" + requestDate + ", fullAddress=" + fullAddress + ", zipCode=" + zipCode
				+ ", phone=" + phone + "]";
	}
}

			