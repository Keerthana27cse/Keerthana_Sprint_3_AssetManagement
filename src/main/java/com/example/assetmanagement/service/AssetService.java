package com.example.assetmanagement.service;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.assetmanagement.entity.Asset;
import com.example.assetmanagement.repository.AssetCategoryRepo;
import com.example.assetmanagement.repository.AssetRepo;

@Service
public class AssetService {
	
	@Autowired AssetRepo assetRepo;
	@Autowired AssetCategoryRepo categoryRepo;
	
	
	private final String uploadDir="src/main/resources/static/uploads";

	public List<Asset> getAllAssets()
	{
		return  assetRepo.findAll();
	}
	public Asset getAssetById(Long id)
	{
		return assetRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("No Assets Found "+id));
	}
	
	public List<Asset> filterAssetByCategory(Long categoryId,String keyword) 
	{
		List<Asset>assets;
		
	    if(categoryId==null|| categoryId==0) {
	    	assets=assetRepo.findAll();
	    }
	    else
	    {
	    	
	    	assets=assetRepo.findByCategory_Id(categoryId);
	    }
	    if(keyword!=null&& !keyword.trim().isEmpty())
	    {
	    	String lowerkeyword= keyword.toLowerCase();
	    	assets=assets.stream()
	    			.filter(asset ->asset. getAssetName().toLowerCase().contains(lowerkeyword))
	    			.collect(Collectors.toList());
	    }
	    return assets;
	}

	
	public boolean deleteAsset(Long id) {
	    if (assetRepo.existsById(id)) {
	        Asset asset = assetRepo.findById(id).orElse(null);

	        if (asset != null && asset.getImageUrl() != null) {
	            // Extract the image filename from URL
	            Path uploadPath = Paths.get(uploadDir);
	            String fileName = Paths.get(asset.getImageUrl()).getFileName().toString();
	            Path filePath = uploadPath.resolve(fileName);

	            try {
	                Files.deleteIfExists(filePath); // Delete the image
	            } catch (IOException e) {
	                System.err.println("Failed to delete image: " + e.getMessage());
	                // Optional: continue or throw
	            }
	        }

	        assetRepo.deleteById(id);
	        return true;
	    }

	    return false;
	}

	
	public Asset saveOrUpdateAsset(Asset asset,MultipartFile imageFile) throws IOException
	{
		Path uploadPath=Paths.get(uploadDir);
		if(!Files.exists(uploadPath))
		{
			Files.createDirectories(uploadPath);
			
		}
		if(asset.getId()==null && assetRepo.existsByAssetName(asset.getAssetName()))
		{
			throw new IllegalArgumentException("Asset With the same Name exists");
		}
		if (asset.getId() != null) {
		    Asset existing = assetRepo.findById(asset.getId()).orElse(null);
		    if (existing != null) {
		        asset.setCreatedAt(existing.getCreatedAt()); // ✅ Preserve original
		    }
		}

		
		
		if(!imageFile.isEmpty())
		{
			String contentType=imageFile.getContentType();
			long size=imageFile.getSize();
			
			 if (contentType == null || !contentType.startsWith("image/")) {
			        throw new IllegalArgumentException("Only image files are allowed");
			    }
			if(size >2*1024*1024)
			{
				throw new IllegalArgumentException("Image size must be under 2MB");
			}
		if(asset.getId()!=null)
		{
			Asset existing=assetRepo.findById(asset.getId()).orElse(null);
			if(existing!=null && existing.getImageUrl()!=null)
			{
				String oldPath=Paths.get(existing.getImageUrl()).getFileName().toString();
				Path oldFile=uploadPath.resolve(oldPath);
				Files.deleteIfExists(oldFile);
			}
		}
		String UniqueFilename= UUID.randomUUID()+"_"+imageFile.getOriginalFilename();
		Path filePath=uploadPath.resolve(UniqueFilename);
		Files.copy(imageFile.getInputStream(),filePath,StandardCopyOption.REPLACE_EXISTING);
		asset.setImageUrl("/uploads/"+UniqueFilename);
		}
		else if(asset.getId()!=null)
		{
			Asset existing=assetRepo.findById(asset.getId()).orElse(null);
		    if(existing!=null)
		    {
		    	asset.setImageUrl(existing.getImageUrl());
		    }
		}
	    Asset saved = assetRepo.save(asset);
	    Asset reloaded = assetRepo.findById(saved.getId()).orElse(saved);
	    System.out.println("Saved asset createdAt: " + reloaded.getCreatedAt());
	    return reloaded;

		
	}
}
