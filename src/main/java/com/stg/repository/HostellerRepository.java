package com.stg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.stg.model.HostelRoom;
import com.stg.model.Hosteller;

@Repository
public interface HostellerRepository extends JpaRepository<Hosteller, Integer> {

	public String deleteByHostelrName(String hostelrName);

	public Hosteller findByhostelrName(String hostelrName);

	public boolean existsByHostelrName(String hostelrName);

	@Query(value = "select * from rooms where typeOfSharing = ?", nativeQuery = true)
	public abstract List<HostelRoom> findByRoomSharing(int typeOfSharing);

	// public abstract List<HostelRoom> findByHostCode(int hostcode);
//	@Query(value="delete * from hosteller where hostelrNum=?",nativeQuery = true)
//	public Hosteller deleteHosteller(Hosteller hosteller);

	@Query(value = "select * from hosteller where hostCode=?", nativeQuery = true)
	public List<Hosteller> readAllHostellers(Hosteller hosteller);

	@Query(value = "select * from hosteller where hosteller_name=?", nativeQuery = true)
	public List<Hosteller> getAll(String hostelrName);

	@Query(value = "select * from hosteller where room_id=?", nativeQuery = true)
	public List<Hosteller> getHostellers(int roomId);

}
