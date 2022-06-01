package com.stg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stg.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

	public String findByAdminName(String adminName);
}
