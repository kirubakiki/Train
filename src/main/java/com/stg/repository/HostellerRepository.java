package com.stg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stg.model.Hostel;
import com.stg.model.Hosteller;

@Repository
public interface HostellerRepository extends JpaRepository<Hosteller, Integer> {

	public String deleteByHostelrName(String hostelrName);

	public Hosteller findByhostelrName(String hostelrName);

	public boolean existsByHostelrName(String hostelrName);

}
