package com.stg.service;

import java.util.List;

import com.stg.model.Admin;


public interface AdminService {

	public abstract Admin createAdmin(Admin admin);

	public abstract Admin readAdminByAdminId(int adminId);

	public abstract int deleteByAdminId(int adminId);

	 public abstract List<Admin> getadmins(); 
}
