package com.example.assetmanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

@Entity
public class AssetCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Category name is required")
    @Column(name = "category_name", nullable = false, unique = true)
    private String categoryName;

    // Optional: back reference to assets (if you want)
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Asset> assets;
    

    // Constructors
    public AssetCategory() {}

    public AssetCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    // Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    public Set<Asset> getAssets() { return assets; }
    public void setAssets(Set<Asset> assets) { this.assets = assets; }

	@Override
	public String toString() {
		return "AssetCategory [id=" + id + ", categoryName=" + categoryName + ", assets=" + assets + "]";
	}

}
