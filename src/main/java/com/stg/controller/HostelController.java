package com.stg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stg.model.Admin;
import com.stg.model.Hostel;
import com.stg.service.HostelService;
import com.stg.service.HostelServiceImpl;

@RestController
@RequestMapping(value = "host")
@CrossOrigin(origins = "http://localhost:4200")
public class HostelController {
	@Autowired
	private HostelServiceImpl hostelService;

	@PostMapping(value = "createhost", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Hostel createhost(@RequestBody Hostel hostel) {

		return hostelService.createHost(hostel);
	}

	@GetMapping(value = "/readhostbycode/{alias}")
	public Hostel readByHostCode(@PathVariable("alias") int hostCode) {

		return hostelService.readHostByCode(hostCode);
	}

	@GetMapping(value = "/readhostbyname/{alias}")
	public Hostel readHostByName(@PathVariable("alias") String hostName) {
		return hostelService.readHostByName(hostName);
	}

	@GetMapping(value = "/getalls")
	public List<Hostel> getAll() {
		return hostelService.getHostels();
	}
	
	@GetMapping(value = "/getbycode/{hostCode}")
	public Hostel getHostelByHostCode(@PathVariable int hostCode) {
		return hostelService.getHostelByHostCode(hostCode);
	}

	@PutMapping(value = "/updatehost",consumes = MediaType.APPLICATION_JSON_VALUE)
	public Hostel updateHost(@RequestBody Hostel hostel) {
		return hostelService.updateHost(hostel);
	}

	@DeleteMapping(value = "/deletehost/{alias}")
	public int deleteHostByCode(@PathVariable("alias") int hostCode) {
		return hostelService.deleteHostByCode(hostCode);
	}
	/*
	 * @DeleteMapping(value = "/deletehostbyname/{alias}") public String
	 * deletehostbyname(@PathVariable("alias") String hostName) { return
	 * hostelService.deleteHostByName(hostName); }
	 */

}
