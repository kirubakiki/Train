package com.stg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stg.model.HostelRoom;
import com.stg.service.RoomService;

@RestController
@RequestMapping(value = "room")
@CrossOrigin(origins = "http://localhost:4200/")
public class RoomController {

	@Autowired
	private RoomService roomService;

	@PostMapping(value = "createroom", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public HostelRoom createRoom(@RequestBody HostelRoom hostelRoom) {
		return roomService.createRoom(hostelRoom);
	}

	@GetMapping(value = "/getVacancy/{alias}")
	public int getRoomByVacancy(@PathVariable("alias") int roomVacancy) {
		return roomService.getRoomByVacancy(roomVacancy);
	}
}
