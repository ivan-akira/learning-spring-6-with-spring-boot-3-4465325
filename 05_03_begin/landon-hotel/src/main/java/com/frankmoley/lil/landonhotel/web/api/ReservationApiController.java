package com.frankmoley.lil.landonhotel.web.api;

import com.frankmoley.lil.landonhotel.data.entity.Reservation;
import com.frankmoley.lil.landonhotel.data.repository.ReservationRepository;
import com.frankmoley.lil.landonhotel.web.exception.BadRequestException;
import com.frankmoley.lil.landonhotel.web.exception.NotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reservations")
public class ReservationApiController {
  private final ReservationRepository reservationRepository;

  @GetMapping
  public List<Reservation> getAllReservations(@RequestParam(name = "reservationDate", required = false) LocalDate reservationDate) {
    if (!Objects.isNull(reservationDate)) {
      return reservationRepository.findAllByReservationDate(java.sql.Date.valueOf(reservationDate));
    }
    return reservationRepository.findAll();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Reservation createReservation(@RequestBody Reservation reservation) {
    return reservationRepository.save(reservation);
  }

  @GetMapping("/{id}")
  public Reservation getReservationById(@PathVariable("id") long id) {
    return reservationRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("reservation not found with id: " + id));
  }

  @PutMapping("/{id}")
  public Reservation updateReservationById(@PathVariable("id") long id, @RequestBody Reservation reservation) {
    if (id != reservation.getId()) {
      throw new BadRequestException("id on path doesn't match body");
    }
    return reservationRepository.save(reservation);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.RESET_CONTENT)
  public void deleteReservationById(@PathVariable("id") long id) {
    reservationRepository.deleteById(id);
  }
}
