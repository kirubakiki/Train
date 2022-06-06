/*
 * package com.stg.model;
 * 
 * import java.util.List; import java.util.Set;
 * 
 * import javax.persistence.CascadeType; import javax.persistence.Column; import
 * javax.persistence.Entity; import javax.persistence.FetchType; import
 * javax.persistence.GeneratedValue; import javax.persistence.GenerationType;
 * import javax.persistence.Id; import javax.persistence.JoinColumn; import
 * javax.persistence.ManyToOne; import javax.persistence.OneToMany; import
 * javax.persistence.Table;
 * 
 * import com.fasterxml.jackson.annotation.JsonBackReference; import
 * com.fasterxml.jackson.annotation.JsonManagedReference;
 * 
 * import lombok.AllArgsConstructor; import lombok.Getter; import
 * lombok.NoArgsConstructor; import lombok.Setter;
 * 
 * 
 * @Entity
 * 
 * @Table(name = "rooms") public class HostelRoom {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY) private int roomId;
 * 
 * @Column(name = "sharing") private String typeOfSharing;
 * 
 * @Column(name = "Room_Number") private String roomNumber;
 * 
 * @Column(name = "Room_Vacancy") private int roomVacancy;
 * 
 * @Column(name = "Room_Occupied") private int roomOccupied;
 * 
 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) private
 * Set<Hosteller> hostellers;
 * 
 * public HostelRoom() { super(); }
 * 
 * public HostelRoom(int roomId, String typeOfSharing, String roomNumber, int
 * roomVacancy, int roomOccupied, Set<Hosteller> hostellers) { super();
 * this.roomId = roomId; this.typeOfSharing = typeOfSharing; this.roomNumber =
 * roomNumber; this.roomVacancy = roomVacancy; this.roomOccupied = roomOccupied;
 * this.hostellers = hostellers; }
 * 
 * public int getRoomId() { return roomId; }
 * 
 * public void setRoomId(int roomId) { this.roomId = roomId; }
 * 
 * public String getTypeOfSharing() { return typeOfSharing; }
 * 
 * public void setTypeOfSharing(String typeOfSharing) { this.typeOfSharing =
 * typeOfSharing; }
 * 
 * public String getRoomNumber() { return roomNumber; }
 * 
 * public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber;
 * }
 * 
 * public int getRoomVacancy() { return roomVacancy; }
 * 
 * public void setRoomVacancy(int roomVacancy) { this.roomVacancy = roomVacancy;
 * }
 * 
 * public int getRoomOccupied() { return roomOccupied; }
 * 
 * public void setRoomOccupied(int roomOccupied) { this.roomOccupied =
 * roomOccupied; }
 * 
 * public Set<Hosteller> getHostellers() { return hostellers; }
 * 
 * public void setHostellers(Set<Hosteller> hostellers) { this.hostellers =
 * hostellers; }
 * 
 * 
 * }
 */