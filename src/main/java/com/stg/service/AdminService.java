package com.stg.service;

import java.util.List;

import com.stg.model.Admin;

public interface AdminService {

	public abstract Admin createAdmin(Admin admin);

	public abstract Admin readAdminByAdminId(int adminId);

	public abstract int deleteByAdminId(int adminId);

	public abstract List<Admin> getadmins();

	public abstract Admin updateAdmin(Admin admin);

	public abstract Admin Login(String adminName, String adminPassword);
	
	public abstract Admin getAdminByAdminId(int adminId);
}
