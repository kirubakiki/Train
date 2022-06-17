package com.stg.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.exception.GeneralException;
import com.stg.model.Admin;
import com.stg.model.Hostel;
import com.stg.model.Hosteller;
import com.stg.repository.HostelRepository;

@Service
public class HostelServiceImpl implements HostelService {
	@Autowired
	private HostelRepository hostelRepository;

	@Override
	public Hostel createHost(Hostel hostel) {

		return hostelRepository.save(hostel);

	}

	@Override
	public List<Hostel> getHostels() {

		return hostelRepository.findAll();
	}

	@Override
	public Hostel readHostByCode(int hostCode) {

		Optional<Hostel> optionalHostel = hostelRepository.findById(hostCode);

		Hostel hostel = optionalHostel.get();

		return hostel;
	}

	@Override
	public Hostel readHostByName(String hostName) {

		return hostelRepository.findByHostName(hostName);
	}

	@Override
	public Hostel updateHost(Hostel hostel) {
		
		return hostelRepository.save(hostel);
	}

	@Override
	public int deleteHostByCode(int hostCode) {

		if (hostelRepository.existsById(hostCode)) {
			hostelRepository.deleteById(hostCode);
			System.out.println(" deleted : " + hostCode);

		} else {
			return 0;
		}

		return hostCode;
	}

	@Override
	public Hostel getHostelByHostCode(int hostCode) {
		
		Hostel tempHostel = null;
		if(hostelRepository.existsById(hostCode)) {
			tempHostel = hostelRepository.findById(hostCode).get();
			return tempHostel;
		}else {
			throw new GeneralException("Hostel Not Found");
		}
		
	}

	/*
	 * @Override
	 * 
	 * @Transactional public String deleteHostByName(String hostName) { String temp
	 * = null; if (hostelRepository.existsByHostName(hostName)) {
	 * hostelRepository.deleteByHostName(hostName); temp = "deleted"; } else { temp
	 * = "Not Deleted"; }
	 * 
	 * return temp; }
	 */
}