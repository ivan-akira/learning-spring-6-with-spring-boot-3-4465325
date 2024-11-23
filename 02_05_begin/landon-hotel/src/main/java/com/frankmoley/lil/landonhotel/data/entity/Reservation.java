package com.frankmoley.lil.landonhotel.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "reservations")
@Data
@ToString
public class Reservation {
  @Id
  @Column(name = "reservation_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @Column(name = "room_id")
  private long roomId;
  @Column(name = "guest_id")
  private long guestId;
  @Column(name = "res_date")
  private LocalDate reservationDate;
}
