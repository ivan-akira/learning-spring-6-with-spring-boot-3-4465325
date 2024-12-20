package com.frankmoley.lil.landonhotel.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;
import java.sql.Date;

@Entity
@Table(name="reservations")
@Data
@ToString
public class Reservation {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservations_seq_generator")
  @SequenceGenerator(name = "reservations_seq_generator", sequenceName = "reservations_seq", initialValue = 2)
  @Column(name="reservation_id")
  private long id;
  @Column(name="room_id")
  private long roomId;
  @Column(name="guest_id")
  private long guestId;
  @Column(name="res_date")
  private Date reservationDate;
}
