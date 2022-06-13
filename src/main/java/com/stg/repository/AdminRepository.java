package com.stg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stg.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

	public Admin findByAdminName(String adminName);

}
