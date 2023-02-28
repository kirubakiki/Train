package com.stg.model;

import java.util.Objects;
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

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Builder;

@Entity
@Table(name = "hostel")
public class Hostel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hostCode;
	@Column(name = "Hostel_Name", length = 25)
	private String hostName;
//	@Column(name = "LANDMARK")
//	private String landMark;
//	@Column(name = "ADDRESS")
//	private String address;
	@Column(name = "CITY")
	private String city;
//	@Column(name = "STATE")
//	private String state;
//	@Column(name = "PINCODE")
//	private String pinCode;
//	@Column(name = "Hostel_Contact", length = 10)
//	private String hostContactNumber;

	@JsonManagedReference(value = "roomhostel")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hostel")
	private Set<HostelRoom> hostelRooms;

	@JsonManagedReference(value = "host")
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "hostel")
	private Set<Hosteller> hostellers;

	@JsonBackReference
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "idadmin", referencedColumnName = "adminId", nullable = false) // nullable done after data feeded
	private Admin admin;

//	@OneToOne
//	@JsonManagedReference(value = "add")
//	private Address address;


	public String getAdminName() {
		return admin.getAdminName();
	}

	public Hostel() {
		super();
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<HostelRoom> getHostelRooms() {
		return hostelRooms;
	}

	public void setHostelRooms(Set<HostelRoom> hostelRooms) {
		this.hostelRooms = hostelRooms;
	}

	public Set<Hosteller> getHostellers() {
		return hostellers;
	}

	public void setHostellers(Set<Hosteller> hostellers) {
		this.hostellers = hostellers;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Hostel(int hostCode, String hostName, String city, Set<HostelRoom> hostelRooms, Set<Hosteller> hostellers,
			Admin admin) {
		super();
		this.hostCode = hostCode;
		this.hostName = hostName;
		this.city = city;
		this.hostelRooms = hostelRooms;
		this.hostellers = hostellers;
		this.admin = admin;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Hostel hostel = (Hostel) o;
		return hostCode == hostel.hostCode && hostName.equals(hostel.hostName) && city.equals(hostel.city);
	}

	@Override
	public int hashCode() {
		return Objects.hash(hostCode, hostName, city);
	}

}
