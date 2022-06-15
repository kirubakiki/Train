
package com.stg.service;

import java.util.List;

import com.stg.model.Hostel;
import com.stg.model.HostelRoom;

public interface RoomService {

	public abstract HostelRoom createRoom(HostelRoom hostelRoom);

	public abstract HostelRoom readRoomByNumber(int roomId);

	public abstract List<HostelRoom> getRooms();

	public abstract int deleteRoomById(int roomId);

	public abstract HostelRoom updateRoom(HostelRoom hostelRoom);
	
	public abstract int numberOfSharing(int typeOfSharing);
	
	public abstract int numberOfOccupancy(int roomOccupied);
	
	public abstract int numberOfVacancy(int roomVacancy);
	
	
}
