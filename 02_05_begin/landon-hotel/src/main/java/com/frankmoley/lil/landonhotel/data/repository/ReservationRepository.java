package com.frankmoley.lil.landonhotel.data.repository;

import com.frankmoley.lil.landonhotel.data.entity.Reservation;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
  List<Reservation> getAllByReservationDate(LocalDate reservationDate);
}
