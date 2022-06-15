
package com.stg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stg.model.HostelRoom;

@Repository
public interface RoomRepository extends JpaRepository<HostelRoom, Integer> {
	
	public abstract boolean existsByRoomNumber(int roomNumber);
	
	@Query(value =  "select * from rooms where hostelcode = ?",nativeQuery = true)
	public abstract List<HostelRoom> findByHostCode(int hostcode);

}

