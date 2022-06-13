package com.stg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.exception.GeneralException;
import com.stg.model.Admin;
import com.stg.model.Hosteller;
import com.stg.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Admin createAdmin(Admin admin) {

		if (admin.getAdminName().equals(adminRepository.findByAdminName(admin.getAdminName()))) {

			throw new GeneralException("AdminName Already Exists!");
		} else {
			adminRepository.save(admin);
		}
		return admin;
	}

	@Override
	public Admin readAdminByAdminId(int adminId) {
		Admin admin = null;
		Optional<Admin> optional = adminRepository.findById(adminId);
		admin = optional.get();
		return admin;
	}

	@Override
	public List<Admin> getadmins() {

		return adminRepository.findAll();
	}

	@Override
	public Admin updateAdmin(Admin admin) {

		return adminRepository.save(admin);
	}

	@Override
	public int deleteByAdminId(int adminId) {
		if (adminRepository.existsById(adminId)) {
			adminRepository.deleteById(adminId);
		}
		return adminId;
	}

	@Override
	public Admin Login(String adminName, String adminPassword) {
		Admin tempadmin = adminRepository.findByAdminName(adminName);
		if (tempadmin != null) {
			if (tempadmin.getAdminPassword().equals(adminPassword)) {
				return tempadmin;
			} else {
				throw new GeneralException("Wrong Credentials");
			}

		} else {
			throw new GeneralException("Admin Not Found");
		}

	}
}
