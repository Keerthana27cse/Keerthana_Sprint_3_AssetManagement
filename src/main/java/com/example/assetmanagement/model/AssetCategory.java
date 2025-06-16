package com.example.assetmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class AssetCategory {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id; 
	private String categoryName;
	public AssetCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AssetCategory(Long id, String categoryName) {
		super();
		this.id = id;
		this.categoryName = categoryName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "AssetCategory [id=" + id + ", categoryName=" + categoryName + "]";
	}
	
	
	}

