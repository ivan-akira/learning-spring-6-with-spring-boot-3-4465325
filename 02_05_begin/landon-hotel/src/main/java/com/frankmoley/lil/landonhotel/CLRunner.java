package com.frankmoley.lil.landonhotel;

import com.frankmoley.lil.landonhotel.data.entity.Room;
import com.frankmoley.lil.landonhotel.data.repository.GuestRepository;
import com.frankmoley.lil.landonhotel.data.repository.ReservationRepository;
import com.frankmoley.lil.landonhotel.data.repository.RoomRepository;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class CLRunner implements CommandLineRunner {

  private final RoomRepository roomRepository;
  private final GuestRepository guestRepository;
  private final ReservationRepository reservationRepository;

  @Override
  public void run(String... args) throws Exception {
    List<Room> rooms = this.roomRepository.findAll();
    Optional<Room> room = this.roomRepository.findByRoomNumberIgnoreCase("p1");
    System.out.println(room);
    rooms.forEach(System.out::println);

    final var guests = guestRepository.findAll();
    guests.forEach(System.out::println);

    final var reservations = reservationRepository.getAllByReservationDate(LocalDate.of(2023, 8, 28));
    reservations.forEach(System.out::println);
  }
}
