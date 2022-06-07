
package com.stg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.exception.GeneralException;
import com.stg.model.HostelRoom;

import com.stg.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomRepository roomRepository;

	@Override
	public HostelRoom createRoom(HostelRoom hostelRoom) {
		roomRepository.existsByRoomNumber(hostelRoom.getRoomNumber());
		boolean isRooms = roomRepository.existsByRoomNumber(hostelRoom.getRoomNumber());
		if (isRooms != true) {
			return roomRepository.save(hostelRoom);
		} else {
			throw new GeneralException("Room Number Already Exists");
		}

	}

	@Override
	public List<HostelRoom> getRooms() {

		return roomRepository.findAll();
	}

	@Override
	public HostelRoom readRoomByNumber(int roomId) {

		Optional<HostelRoom> optionalHostel = roomRepository.findById(roomId);

		HostelRoom hostelRoom = optionalHostel.get();

		return hostelRoom;
	}

	@Override
	public HostelRoom updateRoom(HostelRoom hostelRoom) {

		return roomRepository.save(hostelRoom);
	}

	@Override
	public int deleteRoomById(int roomId) {

		if (roomRepository.existsById(roomId)) {
			roomRepository.deleteById(roomId);
			System.out.println(" deleted : " + roomId);

		} else {
			return 0;
		}

		return roomId;
	}

}
