package com.stg.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.stg.model.Admin;
import com.stg.service.AdminService;

class AdminControllerTest {
	@Mock
	private AdminService adminService;

	@InjectMocks
	private AdminController adminController;

	@Autowired
	private MockMvc mockMvc;
	
	private Admin  admin;

	@Test
	void testCreatehost() {
		Mockito.when(adminService.createAdmin(admin)).thenReturn(admin);
		
		
	}

	@Test
	void testGenerateToken() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllAdmin() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateAdmin() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteByAdminId() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAdminByAdminId() {
		fail("Not yet implemented");
	}

	@Test
	void testLogin() {
		fail("Not yet implemented");
	}

}
