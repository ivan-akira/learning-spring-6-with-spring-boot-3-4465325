package com.frankmoley.lil.landonhotel.web.controller;

import com.frankmoley.lil.landonhotel.service.RoomReservationService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/occupancy")
public class OccupancyController {
  private static final DateTimeFormatter DEFAULT_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyy-MM-dd");

  private final RoomReservationService roomReservationService;

  @GetMapping
  public String getOccupancy(Model model, @RequestParam(name = "reservationDate", required = false) String reservationDate) {
    if (Objects.isNull(reservationDate) || reservationDate.isEmpty()) {
      reservationDate = LocalDate.now().format(DEFAULT_DATE_TIME_FORMATTER);
    }
    model.addAttribute("reservationDate", reservationDate);
    model.addAttribute("roomReservations", roomReservationService.getRoomReservationsForDate(reservationDate));
    return "occupancy";
  }
}
