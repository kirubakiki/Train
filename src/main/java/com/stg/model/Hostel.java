package com.stg.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "hostel")
public class Hostel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hostCode;
	@Column(name = "Hostel_Name", length = 25)
	private String hostName;
	@Column(name = "LANDMARK")
	private String landMark;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "CITY")
	private String city;
	@Column(name = "STATE")
	private String state;
	@Column(name = "PINCODE")
	private String pinCode;
	@Column(name = "Hostel_Contact", length = 10)
	private String hostContactNumber;

	@JsonManagedReference(value = "roomhostel")
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "hostel")
	private Set<HostelRoom> hostelRooms;

//	@JsonManagedReference(value = "host")
//	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "hostel")
//	private Set<Hosteller> hostellers;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "idadmin", referencedColumnName = "adminId", nullable =false) // nullable done after data feeded
	private Admin admin;
//
//	@OneToOne
//	@JsonManagedReference(value = "add")
//	private Address address;

	public Hostel() {
		super();
	}

	public Hostel(int hostCode, String hostName, String landMark, String address, String city, String state,
			String pinCode, String hostContactNumber, Set<HostelRoom> hostelRooms, Set<Hosteller> hostellers,
			Admin admin) {
		super();
		this.hostCode = hostCode;
		this.hostName = hostName;
		this.landMark = landMark;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
		this.hostContactNumber = hostContactNumber;
		this.hostelRooms = hostelRooms;
	//	this.hostellers = hostellers;
		this.admin = admin;
	}

	public int getHostCode() {
		return hostCode;
	}

	public void setHostCode(int hostCode) {
		this.hostCode = hostCode;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getHostContactNumber() {
		return hostContactNumber;
	}

	public void setHostContactNumber(String hostContactNumber) {
		this.hostContactNumber = hostContactNumber;
	}

	public Set<HostelRoom> getHostelRooms() {
		return hostelRooms;
	}

	public void setHostelRooms(Set<HostelRoom> hostelRooms) {
		this.hostelRooms = hostelRooms;
	}

//	public Set<Hosteller> getHostellers() {
//		return hostellers;
//	}
//
//	public void setHostellers(Set<Hosteller> hostellers) {
//		this.hostellers = hostellers;
//	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

}
