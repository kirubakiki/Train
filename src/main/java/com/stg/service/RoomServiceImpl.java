
package com.stg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.exception.GeneralException;
import com.stg.model.Hostel;
import com.stg.model.HostelRoom;

import com.stg.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomRepository roomRepository;

	@Override
	public HostelRoom createRoom(HostelRoom hostelRoom) {

		List<HostelRoom> list = roomRepository.findByHostCode(hostelRoom.getHostel().getHostCode());

		for (HostelRoom hostelRoom2 : list) {
			if (hostelRoom.getRoomNumber() != hostelRoom2.getRoomNumber()) {
				System.out.println(hostelRoom.getHostel().getHostCode() + "//////////////////////");
				roomRepository.save(hostelRoom);
			} else {
				throw new GeneralException("Room Number Already Exists");
			}
		}
		return roomRepository.save(hostelRoom);
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

	@Override
	public HostelRoom readByNumberOfSharing(int typeOfSharing) {
		Optional<HostelRoom> optionalHostel = roomRepository.findById(typeOfSharing);

		HostelRoom hostelRoom = optionalHostel.get();

		return hostelRoom;
	}

	@Override
	public HostelRoom readByNumberOfOccupancy(int roomOccupied) {

		Optional<HostelRoom> optionalHostel = roomRepository.findById(roomOccupied);

		HostelRoom hostelRoom = optionalHostel.get();

		return hostelRoom;
	}

	

	@Override
	public HostelRoom getRoomByRoomId(int roomId) {
		HostelRoom tempHostelroom = null;
		if (roomRepository.existsById(roomId)) {
			tempHostelroom = roomRepository.findById(roomId).get();
			return tempHostelroom;
		} else {
			throw new GeneralException("Room Not Found");
		}

	}

	@Override
	public List<HostelRoom> getRooms(int hostCode) {

		return roomRepository.getRooms(hostCode);

	}

	@Override
	public List<HostelRoom> readByNumberOfVacancy(int roomVacancy) {
		
		return roomRepository.findAll();
	}

	@Override
	public List<HostelRoom> getVacancyRooms(int roomVacancy) {
		
		return null;
	}

}
