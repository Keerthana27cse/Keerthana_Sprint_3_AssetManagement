package com.example.assetmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.assetmanagement.model.User;
import com.example.assetmanagement.model.UserRole;


public class UserTest {

    @Test
    public void testConstructor() {
        User user = new User(1L, "adminuser", "adminpass", "admin@example.com", UserRole.ADMIN);

        assertEquals(1L, user.getId());
        assertEquals("adminuser", user.getUsername());
        assertEquals("adminpass", user.getPassword());
        assertEquals("admin@example.com", user.getEmail());
        assertEquals(UserRole.ADMIN, user.getRole());
    }

    @Test
    public void testGettersAndSetters() {
        User user = new User();
        user.setId(2L);
        user.setUsername("employeeuser");
        user.setPassword("emppass");
        user.setEmail("employee@example.com");
        user.setRole(UserRole.EMPLOYEE);

        assertEquals(2L, user.getId());
        assertEquals("employeeuser", user.getUsername());
        assertEquals("emppass", user.getPassword());
        assertEquals("employee@example.com", user.getEmail());
        assertEquals(UserRole.EMPLOYEE, user.getRole());
    }

    @Test
    public void testToString() {
        User user = new User(3L, "hruser", "hrpass", "hr@example.com", UserRole.EMPLOYEE);

        String expected = "User [id=3, username=hruser, password=hrpass, email=hr@example.com, role=EMPLOYEE]";
        assertEquals(expected, user.toString());
    }
}
