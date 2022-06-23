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
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Hosteller {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hostelrNum;
	@Column(name = "Hosteller_Name", length = 30, nullable = false)
	private String hostelrName;
	@Column(name = "gender", length = 15)
	private String gender;
	@Column(name = "Hosteller_Dob", nullable = false)
	private LocalDate hostelrdob;
	@Column(name = "Date_Of_Joining", nullable = false)
	private LocalDate entryDate;
	@Column(name = "Marital_Status", nullable = false,length = 10)
	private String hostelrMarStatus;
	@Column(name = "Address", length = 70, nullable = false)
	private String hostellerAddress;
	@Column(name = "pincode", length = 6, nullable = false)
	private int hostellerPincode;
	@Column(name = "Mobile_Number", length = 10, nullable = false)
	private String hostellerMobile;
	@Column(name = "DepositAmount", nullable = false)
	private int depositAmount;

	@JsonBackReference(value = "user")
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	@JoinColumn(name = "roomId", referencedColumnName = "roomId", nullable = false)
	private HostelRoom hostelRoom;

//	@JsonBackReference(value = "host")
//	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
//	@JoinColumn(name = "hostelcode", referencedColumnName = "hostCode", nullable = false)
//	private Hostel hostel;

	public Hosteller() {
		super();
	}

	public Hosteller(int hostelrNum, String hostelrName, String gender, LocalDate hostelrdob, LocalDate entryDate,
			String hostelrMarStatus, String hostellerAddress, int hostellerPincode, String hostellerMobile,
			int hostellerAdvance, HostelRoom hostelRoom, Hostel hostel) {
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
		this.depositAmount = hostellerAdvance;
		this.hostelRoom = hostelRoom;
		//this.hostel = hostel;
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

	public HostelRoom getHostelRoom() {
		return hostelRoom;
	}

	public void setHostelRoom(HostelRoom hostelRoom) {
		this.hostelRoom = hostelRoom;
	}

//	public Hostel getHostel() {
//		return hostel;
//	}
//
//	public void setHostel(Hostel hostel) {
//		this.hostel = hostel;
//	}

//	@OneToOne
//	@JsonManagedReference(value="addres")
//	private Address address;

}
