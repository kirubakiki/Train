package com.stg.model;

import java.util.List;
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
@Table(name = "rooms")
public class HostelRoom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roomId;

	@Column(name = "sharing")
	private String typeOfSharing;

	@Column(name = "Room_Number")
	private String roomNumber;

	@Column(name = "Room_Vacancy")
	private int roomVacancy;

	@Column(name = "Room_Occupied")
	private int roomOccupied;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Hosteller> hostellers;

}
