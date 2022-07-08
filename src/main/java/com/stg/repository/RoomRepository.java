
package com.stg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stg.model.HostelRoom;

@Repository
public interface RoomRepository extends JpaRepository<HostelRoom, Integer> {

	public abstract boolean existsByRoomNumber(int roomNumber);

	@Query(value = "select * from rooms where hostelcode = ?", nativeQuery = true)
	public abstract List<HostelRoom> findByHostCode(int hostcode);
	
	@Query(value = "select * from rooms where roomNumber = ?", nativeQuery = true)
	public abstract List<HostelRoom> findyByRoomNumber(int roomNumber);
	
	public HostelRoom findByRoomId(int roomId);
	
	@Query(value = "select * from rooms where hostelcode=?",nativeQuery = true)
	public List<HostelRoom> getRooms(int hostCode);
	
	
	@Query(value = "select * from rooms where room_vacancy=?",nativeQuery = true)
	public abstract List<HostelRoom> findByNoOfVacancy(int roomVacancy );
//	
//	public abstract int noOfOccupied(int roomOccupied );
	
//	@Query(value = "delete * from room where hostelrNum=?")
//	public abstract List<HostelRoom> deleteByHostlrCode(int hostelrNum);

}
