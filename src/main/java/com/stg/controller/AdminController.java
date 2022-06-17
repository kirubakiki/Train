package com.stg.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stg.model.Admin;
import com.stg.model.Constants;
import com.stg.model.Hostel;
import com.stg.service.AdminService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

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

	@PostMapping(value = "/authenticate")
	public Map<String, String> generateToken(@RequestBody Admin admin) {
		long timestamp = System.currentTimeMillis();
		String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, Constants.API_SECRET_KEY)
				.setIssuedAt(new Date(timestamp)).setExpiration(new Date(timestamp + Constants.TOKEN_VALIDITY))
				.claim("admiId", admin.getAdminId()).claim("adminName", admin.getAdminName())
				.claim("adminPassword", admin.getAdminPassword()).compact();

		Map<String, String> map = new HashMap<>();
		map.put("JWT", token);
		return map;
	}

	@GetMapping(value = "/getadminlists")
	public List<Admin> getAllAdmin() {
		return adminService.getadmins();
	}

	@PutMapping(value = "/getadminlist")
	public Admin updateAdmin(@RequestBody Admin admin) {
		return adminService.updateAdmin(admin);
	}

	@DeleteMapping(value = "/getadminlists/{adminId}")
	public int deleteByAdminId(@PathVariable int adminId) {
		return adminService.deleteByAdminId(adminId);
	}
	
	@GetMapping(value = "/getadminlists/{adminId}")
	public Admin getAdminByAdminId(@PathVariable int adminId) {
		return adminService.getAdminByAdminId(adminId);
	}

	@GetMapping(value = "/adminlogin")
	public Admin Login(@RequestParam String adminName, @RequestParam String adminPassword) {
		return adminService.Login(adminName, adminPassword);
	}

}
