
package com.stg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stg.model.HostelRoom;

@Repository
public interface RoomRepository extends JpaRepository<HostelRoom, Integer> {
	
	public abstract boolean existsByRoomNumber(String roomNumber);

}
