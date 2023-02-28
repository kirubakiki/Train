package com.stg.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.stg.model.Hostel;

@Repository
public interface HostelRepository extends JpaRepository<Hostel, Integer> {

	public String deleteByHostName(String hostName);

	public Hostel findByHostName(String hostName);

	public Hostel readByHostName(String hostName);

}
