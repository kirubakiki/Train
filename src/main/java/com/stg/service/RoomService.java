
package com.stg.service;

import java.util.List;


import com.stg.model.HostelRoom;

public interface RoomService {

	public abstract HostelRoom createRoom(HostelRoom hostelRoom);

	public abstract HostelRoom readRoomByNumber(int roomId);

	public abstract List<HostelRoom> getRooms();

	public abstract int deleteRoomById(int roomId);

	public abstract HostelRoom updateRoom(HostelRoom hostelRoom);

	public abstract HostelRoom readByNumberOfSharing(int typeOfSharing);

	public abstract HostelRoom readByNumberOfOccupancy(int roomOccupied);

	public abstract List<HostelRoom> readByNumberOfVacancy(int roomVacancy);

	public abstract HostelRoom getRoomByRoomId(int roomId);
	
	public List<HostelRoom> getRooms(int hostCode);

	public List<HostelRoom> getVacancyRooms(int roomVacancy);

}
