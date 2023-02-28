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
import org.springframework.web.bind.annotation.RestController;

import com.stg.dao.HostellerDao;

import com.stg.model.Hosteller;
import com.stg.service.HostellerService;

@RestController
@RequestMapping(value = "hostlr")
@CrossOrigin(origins = "http://localhost:4200")
public class HostellerController {
	@Autowired
	private HostellerService hostellerServiceImpl;

//	@PostMapping(value = "createhostelr", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public Hosteller createHostlr(@RequestBody Hosteller hosteller) {
//		return hostellerServiceImpl.createHostlr(hosteller);
//	}
//	

	@PostMapping(value = "createHosteller11", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Hosteller createHostlr11(@RequestBody HostellerDao hosteller) {
		return hostellerServiceImpl.createHostlr11(hosteller);
	}

	@PostMapping(value = "createhostelr", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Hosteller createHostlr(@RequestBody HostellerDao hostellerDao) {
		return hostellerServiceImpl.createHostlr(hostellerDao);
	}

	@GetMapping(value = "/readbyhostlrnum/{hostlrNum}")
	public Hosteller readHostlrByNum(@PathVariable int hostlrNum) {
		return hostellerServiceImpl.readHostlrByNum(hostlrNum);
	}

	@GetMapping(value = "/readbyhostlrname/{alias}")
	public Hosteller readHostlrByName(@PathVariable("alias") String hostelrName) {
		return hostellerServiceImpl.readHostlrByName(hostelrName);
	}

	@GetMapping(value = "/getalls")
	public List<Hosteller> getAlls() {
		return hostellerServiceImpl.getHostellers();
	}

	@PutMapping(value = "updatehostlr")
	public Hosteller updateHostlr(@RequestBody Hosteller hosteller) {
		return hostellerServiceImpl.updateHostlr(hosteller);
	}

	@DeleteMapping(value = "/deletehostelr/{hostlrNum}")
	public int deleteHostlrByCode(@PathVariable int hostlrNum) {
		return hostellerServiceImpl.deleteHostlrByCode(hostlrNum);
	}

	@DeleteMapping(value = "/deletehostlrbyname/{hostelrName}")
	public String deleteHostlrByName(@PathVariable String hostelrName) {
		return hostellerServiceImpl.deleteHostlrByName(hostelrName);
	}

	@GetMapping(value = "/getbyhstlrnum/{hostelrNum}")
	public Hosteller getHostellerByHostelrNum(@PathVariable int hostelrNum) {
		return hostellerServiceImpl.getHostellerByHostelrNum(hostelrNum);
	}

	@GetMapping(value = "getHostelrName/{hostelrName}")
	public List<Hosteller> getAllHosteller(@PathVariable String hostelrName) {
		return hostellerServiceImpl.getAllHosteller(hostelrName);
	}

	@GetMapping(value = "getHostelelrs/{roomId}")
	public List<Hosteller> getHostellers(@PathVariable int roomId) {
		return hostellerServiceImpl.getHostellers(roomId);
	}

//	@GetMapping(value="getRoomsBy/{hostCode}")
//	public List<HostelRoom> getRooms(@PathVariable int hostCode){
//		return hostellerServiceImpl.getRooms(hostCode);
//	}

}
