package com.example.assetmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.assetmanagement.enums.UserRole;
import com.example.assetmanagement.model.User;
import com.example.assetmanagement.repository.UserRepo;


@SpringBootTest
public class UserRepoTest {
	    
	    @Autowired
	    private UserRepo userRepo;

	    @Test
	    @DisplayName("Test save and findById")
	    public void testSaveUserAndFindById() {
	        User user = new User(null, "adminuser", "adminpass", "admin@example.com", UserRole.ROLE_ADMIN);
	        User saved = userRepo.save(user);

	        Optional<User> found = userRepo.findById(saved.getId());
	        assertTrue(found.isPresent());
	        assertEquals("adminuser", found.get().getUsername());
	        assertEquals(UserRole.ROLE_ADMIN, found.get().getRole());
	    }

	    @Test
	    @DisplayName("Test findByUsername")
	    public void testFindByUsername() {
	        userRepo.save(new User(null, "testuser", "pass123", "test@example.com", UserRole.EMPLOYEE));

	        Optional<User> user = userRepo.findByUsername("testuser");
	        assertTrue(user.isPresent());
	        assertEquals("test@example.com", user.get().getEmail());
	    }

	    @Test
	    @DisplayName("Test findByEmail")
	    public void testFindByEmail() {
	        userRepo.save(new User(null, "emailuser", "pass456", "email@example.com", UserRole.EMPLOYEE));

	        Optional<User> user = Optional.of(userRepo.findByEmail("email@example.com"));
	        assertTrue(user.isPresent());
	        assertEquals("emailuser", user.get().getUsername());
	    }

	    @Test
	    @DisplayName("Test findByUsernameAndPassword")
	    public void testFindByUsernameAndPassword() {
	        userRepo.save(new User(null, "loginuser", "loginpass", "login@example.com", UserRole.EMPLOYEE));

	        Optional<User> user = userRepo.findByUsernameAndPassword("loginuser", "loginpass");
	        assertTrue(user.isPresent());
	        assertEquals("login@example.com", user.get().getEmail());
	    }

	    @Test
	    @DisplayName("Test user not found")
	    public void testUserNotFound() {
	        Optional<User> user = userRepo.findByUsername("nonexistent");
	        assertFalse(user.isPresent());
	    }
	}