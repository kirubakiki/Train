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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
	@Column(name = "ADDRESS_LINE_1")
	private String addressLine1;
	@Column(name = "ADDRESS_LINE_2")
	private String addressLine2;
	@Column(name = "CITY")
	private String city;
	@Column(name = "STATE")
	private String state;
	@Column(name = "PINCODE")
	private String pinCode;
	@Column(name = "Hostel_Contact", length = 10)
	private String hostContactNumber;
	@Column(name = "Hostel_Proprietor", length = 25)
	private String hostProp;

	@JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hostel")
	private Set<HostelRoom> hostelRooms;

	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hostel")
	private Set<Hosteller> hostellers;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idadmin", referencedColumnName = "adminId",nullable = false)
	private Admin admin;

	public Hostel() {
		super();
	}

	public Hostel(int hostCode, String hostName, String landMark, String addressLine1, String addressLine2, String city,
			String state, String pinCode, String hostContactNumber, String hostProp, Set<Hosteller> hostellers,
			Admin admin) {
		super();
		this.hostCode = hostCode;
		this.hostName = hostName;
		this.landMark = landMark;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
		this.hostContactNumber = hostContactNumber;
		this.hostProp = hostProp;
		this.hostellers = hostellers;
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

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
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

	public String getHostProp() {
		return hostProp;
	}

	public void setHostProp(String hostProp) {
		this.hostProp = hostProp;
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

}
