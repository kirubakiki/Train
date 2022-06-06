package com.stg.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
public class Hosteller {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hostelrNum;
	@Column(name = "Hosteller_Name", length = 30, nullable = false, updatable = false)
	private String hostelrName;
	@Column(name = "Hosteller_Age", nullable = false, updatable = false)
	private int hostelrAge;
	@Column(name = "Date_Of_Joining", nullable = false)
	private LocalDate entryDate;
	@Column(name = "Marital_Status", nullable = false, updatable = false, length = 10)
	private String hostelrMarStatus;
	@Column(name = "Address", length = 70, nullable = false, updatable = false)
	private String hostellerAddress;
	@Column(name = "pincode", length = 6, nullable = false, updatable = false)
	private int hostellerPincode;
	@Column(name = "Mobile_Number", length = 10, nullable = false)
	private String hostellerMobile;
	@Column(name = "Advance_Amount", nullable = false)
	private int hostellerAdvance;

//	@ManyToOne(fetch = FetchType.LAZY)
//	private HostelRoom hostelRoom;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	private Hostel hostel;
	


	public Hosteller() {
		super();
	}

	public Hosteller(int hostelrNum, String hostelrName, int hostelrAge, LocalDate entryDate, String hostelrMarStatus,
			String hostellerAddress, int hostellerPincode, String hostellerMobile, int hostellerAdvance,
		 Hostel hostel) {
//		HostelRoom hostelRoom,
		super();
		this.hostelrNum = hostelrNum;
		this.hostelrName = hostelrName;
		this.hostelrAge = hostelrAge;
		this.entryDate = entryDate;
		this.hostelrMarStatus = hostelrMarStatus;
		this.hostellerAddress = hostellerAddress;
		this.hostellerPincode = hostellerPincode;
		this.hostellerMobile = hostellerMobile;
		this.hostellerAdvance = hostellerAdvance;
		//this.hostelRoom = hostelRoom;
		this.hostel = hostel;
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

	public int getHostelrAge() {
		return hostelrAge;
	}

	public void setHostelrAge(int hostelrAge) {
		this.hostelrAge = hostelrAge;
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

	public int getHostellerAdvance() {
		return hostellerAdvance;
	}

	public void setHostellerAdvance(int hostellerAdvance) {
		this.hostellerAdvance = hostellerAdvance;
	}

//	public HostelRoom getHostelRoom() {
//		return hostelRoom;
//	}
//
//	public void setHostelRoom(HostelRoom hostelRoom) {
//		this.hostelRoom = hostelRoom;
//	}

	public Hostel getHostel() {
		return hostel;
	}

	public void setHostel(Hostel hostel) {
		this.hostel = hostel;
	}

}
