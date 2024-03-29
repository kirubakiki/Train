
package com.stg.model;

import java.util.List;

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
@Table(name = "rooms")
public class HostelRoom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roomId;

	@Column(name = "sharing")
	private int typeOfSharing;

	@Column(name = "Room_Number")
	private int roomNumber;

	@Column(name = "Room_Vacancy")
	private int roomVacancy;

	@Column(name = "Room_Occupied")
	private int roomOccupied;

	@JsonManagedReference(value = "user")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hostelRoom")
	private List<Hosteller> hostellers;

	@JsonBackReference(value = "roomhostel")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hostelcode", referencedColumnName = "hostCode", nullable = false)
	private Hostel hostel;

	public HostelRoom() {
		super();
	}

	public HostelRoom(int roomId, int typeOfSharing, int roomNumber, int roomVacancy, int roomOccupied,
			List<Hosteller> hostellers, Hostel hostel) {
		super();
		this.roomId = roomId;
		this.typeOfSharing = typeOfSharing;
		this.roomNumber = roomNumber;
		this.roomVacancy = roomVacancy;
		this.roomOccupied = roomOccupied;
		this.hostellers = hostellers;
		this.hostel = hostel;
	}

	public String getHostName() {
		return hostel.getHostName();
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getTypeOfSharing() {
		return typeOfSharing;
	}

	public void setTypeOfSharing(int typeOfSharing) {
		this.typeOfSharing = typeOfSharing;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getRoomVacancy() {
		return roomVacancy;
	}

	public void setRoomVacancy(int roomVacancy) {
		this.roomVacancy = roomVacancy;
	}

	public int getRoomOccupied() {
		return roomOccupied;
	}

	public void setRoomOccupied(int roomOccupied) {
		this.roomOccupied = roomOccupied;
	}

	public List<Hosteller> getHostellers() {
		return hostellers;
	}

	public void setHostellers(List<Hosteller> hostellers) {
		this.hostellers = hostellers;
	}

	public Hostel getHostel() {
		return hostel;
	}

	public void setHostel(Hostel hostel) {
		this.hostel = hostel;
	}

}
