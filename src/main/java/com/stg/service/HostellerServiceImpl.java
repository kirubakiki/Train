package com.stg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stg.dao.HostellerDao;
import com.stg.exception.GeneralException;

import com.stg.model.HostelRoom;
import com.stg.model.Hosteller;
import com.stg.repository.HostellerRepository;
import com.stg.repository.RoomRepository;

@Service
public class HostellerServiceImpl implements HostellerService {

	@Autowired
	private HostellerRepository hostellerRepository;

	@Autowired
	private RoomRepository roomRepository;

//		Hosteller temphost = null;
//		if (hosteller.getHostelrAge() >= 18 && hosteller.getHostelrAge() <= 60) {
//			if (hosteller.getHostellerAdvance() == 3000) {
//				temphost = hostellerRepository.save(hosteller);
//			} else {
//				throw new GeneralException("Minimum Advance Amount is 3000");
//			}
//
//		} else {
//			throw new GeneralException("Age is Not valid");
//		}

	@Override
	public Hosteller readHostlrByNum(int hostelrNum) {
		Hosteller hosteller = null;
		Optional<Hosteller> optional = hostellerRepository.findById(hostelrNum);
		hosteller = optional.get();
		return hosteller;
	}

	@Override
	public Hosteller readHostlrByName(String hostelrName) {

		return hostellerRepository.findByhostelrName(hostelrName);
	}

	@Override
	public Hosteller updateHostlr(Hosteller hosteller) {

//		System.out.println(hosteller.getRoomId()+"/////////////////////////");
		return hostellerRepository.save(hosteller);
	}

	@Override
	public int deleteHostlrByCode(int hostelrNum) {
		HostelRoom tempRoom = null;
		if (hostellerRepository.existsById(hostelrNum)) {

			Hosteller tempHosteller = hostellerRepository.findById(hostelrNum).get();
			hostellerRepository.deleteById(hostelrNum);
			// tempRoom =
			// roomRepository.findById(tempHosteller.getHostelRoom().getRoomId()).get();

			tempRoom = roomRepository.findById(tempHosteller.getHostelRoom().getRoomId()).get();
			tempRoom.setRoomOccupied(tempRoom.getRoomOccupied() - 1);
			tempRoom.setRoomVacancy(tempRoom.getRoomVacancy() + 1);
			roomRepository.save(tempRoom);

		} else {
			throw new GeneralException("No Hosteller Found");
		}
		return -1;
	}

	@Override
	@Transactional
	public String deleteHostlrByName(String hostelrName) {

		if (hostellerRepository.existsByHostelrName(hostelrName)) {

			hostellerRepository.deleteByHostelrName(hostelrName);

		} else {
			throw new GeneralException("No Hosteller Found");
		}
		return "Deleted " + hostelrName;
	}

	@Override
	public List<Hosteller> getHostellers() {

		return hostellerRepository.findAll();
	}

	@Override
	public Hosteller getHostellerByHostelrNum(int hostelrNum) {
		Hosteller tempHosteller = null;
		if (hostellerRepository.existsById(hostelrNum)) {
			tempHosteller = hostellerRepository.findById(hostelrNum).get();
			return tempHosteller;
		} else {
			throw new GeneralException("Hosteller Not Found");
		}

	}

	@Override
	public Hosteller createHostlr(HostellerDao hostellerDao) {

		Hosteller hosteller = new Hosteller();

		HostelRoom tempRoom = roomRepository.findByRoomId(hostellerDao.getRoomId());

		hosteller.setHostelRoom(tempRoom);
		hosteller.setEntryDate(hostellerDao.getEntryDate());
		hosteller.setDepositAmount(hostellerDao.getDepositAmount());
		hosteller.setGender(hostellerDao.getGender());
		hosteller.setHostellerAddress(hostellerDao.getHostellerAddress());
		hosteller.setHostellerMobile(hostellerDao.getHostellerMobile());
		hosteller.setHostellerPincode(hostellerDao.getHostellerPincode());
		hosteller.setHostelrdob(hostellerDao.getHostelrdob());
		// hosteller.setHostelrMarStatus(hostellerDao.getHostelrMarStatus());
		hosteller.setHostelrName(hostellerDao.getHostelrName());
		hosteller.setHostelrNum(0);

		if ((hosteller.getHostelrdob().getYear() >= 2004) && (hosteller.getHostelrdob().getMonthValue() >= 6)) {
			throw new GeneralException("Age Should Be Above 18");
		} else {

			if (tempRoom.getRoomVacancy() > 0) {

				tempRoom.setRoomOccupied(tempRoom.getRoomOccupied() + 1);
				tempRoom.setRoomVacancy(tempRoom.getRoomVacancy() - 1);
				roomRepository.save(tempRoom);
				return hostellerRepository.save(hosteller);

			} else {
				throw new GeneralException("No Vacancy! Please try other room");
			}

//			 if (hostellerRepository.deleteHosteller(hosteller)) {
//				tempRoom.setRoomOccupied(tempRoom.getRoomOccupied()-1);
//				tempRoom.setRoomVacancy(tempRoom.getRoomVacancy()+1);
//				roomRepository.save(tempRoom);
//		
//			}

		}

	}

	@Override
	public List<Hosteller> getAllHosteller(String hostelrName) {

		return hostellerRepository.getAll(hostelrName);
	}

	@Override
	public List<Hosteller> getHostellers(int roomId) {

		return hostellerRepository.getHostellers(roomId);

	}

	@Override
	public Hosteller createHostlr11(HostellerDao hosteller) {

		Hosteller hosteller2 = new Hosteller();
		hosteller2.setDepositAmount(hosteller.getDepositAmount());
		hosteller2.setEntryDate(hosteller.getEntryDate());
		hosteller2.setGender(hosteller.getGender());
		hosteller2.setHostellerAddress(hosteller.getHostellerAddress());
		hosteller2.setHostellerMobile(hosteller.getHostellerMobile());
		hosteller2.setHostellerPincode(hosteller.getHostellerPincode());
		hosteller2.setHostelrdob(hosteller.getHostelrdob());
		hosteller2.setHostelrName(hosteller.getHostelrName());
		hosteller2.setHostelrNum(hosteller.getHostelrNum());
		hosteller2.setHostelRoom(roomRepository.findByRoomId(hosteller.getRoomId()));
		return hostellerRepository.save(hosteller2);
	}

}
