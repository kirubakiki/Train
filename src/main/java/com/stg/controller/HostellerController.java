package com.stg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stg.exception.GeneralException;
import com.stg.model.Hostel;
import com.stg.model.Hosteller;
import com.stg.service.HostellerService;
import com.stg.service.HostellerServiceImpl;

@RestController
@RequestMapping(value = "hostlr")
@CrossOrigin(origins = "http://localhost:4200/")
public class HostellerController {
	@Autowired
	private HostellerService hostellerServiceImpl;

	@PostMapping(value = "createhostlr", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Hosteller createHostlr(@RequestBody Hosteller hosteller) {
		return hostellerServiceImpl.createHostlr(hosteller);
	}

	@GetMapping(value = "/readbyhostlrnum/{hostlrNum}")
	public Hosteller readHostlrByNum(@PathVariable int hostlrNum) {
		return hostellerServiceImpl.readHostlrByNum(hostlrNum);
	}

	@GetMapping(value = "/readbyhostlrname/{alias}")
	public Hosteller readHostlrByName(@PathVariable("alias") String hostelrName) {
		return hostellerServiceImpl.readHostlrByName(hostelrName);
	}
	
	@GetMapping(value="/getalls")
	public List<Hosteller> getAlls(){
		return hostellerServiceImpl.getHostellers();
	}

	@PutMapping(value = "updatehostlr")
	public Hosteller updateHostlr(@RequestBody Hosteller hosteller) {
		return hostellerServiceImpl.updateHostlr(hosteller);
	}

	@DeleteMapping(value = "/deletehostlrbynum/{hostlrNum}")
	public int deleteHostlrByCode(@PathVariable int hostlrNum) {
		return hostellerServiceImpl.deleteHostlrByCode(hostlrNum);
	}

	@DeleteMapping(value = "/deletehostlrbyname/{hostelrName}")
	public String deleteHostlrByName(@PathVariable String hostelrName) {
		return hostellerServiceImpl.deleteHostlrByName(hostelrName);
	}

}
