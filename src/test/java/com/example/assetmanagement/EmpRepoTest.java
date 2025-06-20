package com.example.assetmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.assetmanagement.enums.Gender;
import com.example.assetmanagement.enums.UserRole;
import com.example.assetmanagement.model.Employee;
import com.example.assetmanagement.repository.EmployeeRepo;


@SpringBootTest
public class EmpRepoTest {
	
	@Autowired
	private EmployeeRepo emprepo;
	
	@Test
	public void testSaveandfindbyemail()
	{
		Employee emp=new Employee();
		emp.setName("Keerthana");
		emp.setEmail("keerthana@gmail.com");
		emp.setPassword("pass123");
		emp.setAddress("kit");
		emp.setGender(Gender.valueOf("FEMALE"));
		emp.setContactNumber("123456789");
		emp.setRole(UserRole.EMPLOYEE);
		
	emprepo.save(emp);
	Employee found= emprepo.findByEmail("keerthana@gmail.com");
	
	assertNotNull(found);
    assertEquals("Keerthana", found.getName());
    assertEquals("keerthana@gmail.com", found.getEmail());
    assertEquals(UserRole.EMPLOYEE, found.getRole());
	
	}
	 @Test
	    public void testFindByEmail_NotFound() {
        Employee found = emprepo.findByEmail("unknown@example.com");
	    assertNull(found);
	 }
	 
	 public void testDeleteById() {
	        Employee emp = new Employee();
	        emp.setName("Test User");
	        emp.setEmail("deleteuser@example.com");
	        emp.setPassword("pass123");
	        emp.setAddress("Test Address");
	        emp.setContactNumber("9876543210");
	        emp.setGender(Gender.FEMALE);
	        emp.setRole(UserRole.EMPLOYEE);

	        Employee savedEmp = emprepo.save(emp);
	        Long empId = savedEmp.getId();
	        
	        assertNotNull(empId, "employee ID  should not null");

	        emprepo.deleteById(empId);

	        boolean exists = emprepo.findById(empId).isPresent();
	        assertFalse(exists, "Employee exists");
	    }
	    /*@AfterEach
	    public void cleanup() {
	        emprepo.deleteAll();
	    }*/
	}
