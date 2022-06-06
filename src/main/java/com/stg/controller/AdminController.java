package com.stg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stg.model.Admin;
import com.stg.model.Hostel;
import com.stg.service.AdminService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "admin")
public class AdminController {
	@Autowired
	private AdminService adminService;

	@PostMapping(value = "admins", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Admin createhost(@RequestBody Admin admin) {

		return adminService.createAdmin(admin);
	}
	@GetMapping(value="/getadminlist")
	public List<Admin> getAllAdmin(){
		return adminService.getadmins();
	}
	@DeleteMapping(value = "/getadminlist/{adminId}")
	public int deleteByAdminId(@PathVariable int adminId) {
		return adminService.deleteByAdminId(adminId);
	}

}
