package com.stg.dao;

import java.time.LocalDate;

public class HostellerDao {

	private int hostelrNum;

	private String hostelrName;

	private String gender;

	private LocalDate hostelrdob;

	private LocalDate entryDate;

	private String hostelrMarStatus;

	private String hostellerAddress;

	private int hostellerPincode;

	private String hostellerMobile;

	private int depositAmount;

	private int roomId;

	public HostellerDao() {
		super();
	}

	public HostellerDao(int hostelrNum, String hostelrName, String gender, LocalDate hostelrdob, LocalDate entryDate,
			String hostelrMarStatus, String hostellerAddress, int hostellerPincode, String hostellerMobile,
			int depositAmount, int roomId) {
		super();
		this.hostelrNum = hostelrNum;
		this.hostelrName = hostelrName;
		this.gender = gender;
		this.hostelrdob = hostelrdob;
		this.entryDate = entryDate;
		this.hostelrMarStatus = hostelrMarStatus;
		this.hostellerAddress = hostellerAddress;
		this.hostellerPincode = hostellerPincode;
		this.hostellerMobile = hostellerMobile;
		this.depositAmount = depositAmount;
		this.roomId = roomId;
	}

	public int getHostelrNum() {
		return hostelrNum;
	}

	public void setHostelrNum(int hostelrNum) {
		this.hostelrNum = hostelrNum;
	}

	public String getHostelrName() {
		return hostelrName;
	}

	public void setHostelrName(String hostelrName) {
		this.hostelrName = hostelrName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getHostelrdob() {
		return hostelrdob;
	}

	public void setHostelrdob(LocalDate hostelrdob) {
		this.hostelrdob = hostelrdob;
	}

	public LocalDate getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}

	public String getHostelrMarStatus() {
		return hostelrMarStatus;
	}

	public void setHostelrMarStatus(String hostelrMarStatus) {
		this.hostelrMarStatus = hostelrMarStatus;
	}

	public String getHostellerAddress() {
		return hostellerAddress;
	}

	public void setHostellerAddress(String hostellerAddress) {
		this.hostellerAddress = hostellerAddress;
	}

	public int getHostellerPincode() {
		return hostellerPincode;
	}

	public void setHostellerPincode(int hostellerPincode) {
		this.hostellerPincode = hostellerPincode;
	}

	public String getHostellerMobile() {
		return hostellerMobile;
	}

	public void setHostellerMobile(String hostellerMobile) {
		this.hostellerMobile = hostellerMobile;
	}

	public int getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(int depositAmount) {
		this.depositAmount = depositAmount;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

}
