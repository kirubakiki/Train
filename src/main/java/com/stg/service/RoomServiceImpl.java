package com.stg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.model.HostelRoom;
import com.stg.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomRepository roomRepository;

	@Override
	public HostelRoom createRoom(HostelRoom hostelRoom) {

		return roomRepository.save(hostelRoom);
	}

	@Override
	public int getRoomByVacancy(int roomVacancy) {

		return 0;
	}

}
