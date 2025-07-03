package com.example.assetmanagement.mapper;

import com.example.assetmanagement.dto.UserDTO;
import com.example.assetmanagement.entity.User;

public class UserMapper {
	
	public static UserDTO toDTO(User user)
	{
		if(user==null) return null;
		
		return UserDTO.builder()
				.id(user.getId())
				.username(user.getUsername())
				.email(user.getEmail())
                .userrole(user.getUserrole())
                .build();
				
	}
	
	public static User toEntity (UserDTO dto)
	{
		if(dto==null) return null;
		
		User user=new User();
		user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setUserrole(dto.getUserrole());
        return user;
	    }
	}