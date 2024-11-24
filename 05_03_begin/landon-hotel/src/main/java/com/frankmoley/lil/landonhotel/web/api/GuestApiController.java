package com.frankmoley.lil.landonhotel.web.api;

import com.frankmoley.lil.landonhotel.data.entity.Guest;
import com.frankmoley.lil.landonhotel.data.repository.GuestRepository;
import com.frankmoley.lil.landonhotel.web.exception.BadRequestException;
import com.frankmoley.lil.landonhotel.web.exception.NotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/guests")
public class GuestApiController {
  private final GuestRepository guestRepository;

  @GetMapping
  public List<Guest> getAllGuests() {
    return guestRepository.findAll();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Guest createGuest(@RequestBody Guest guest) {
    return guestRepository.save(guest);
  }

  @GetMapping("/{id}")
  public Guest getGuestById(@PathVariable("id") long id) {
    return guestRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("guest not found with id: " + id));
  }

  @PutMapping("/{id}")
  public Guest updateGuestById(@PathVariable("id") long id, @RequestBody Guest guest) {
    if (id != guest.getId()) {
      throw new BadRequestException("id on path doesn't match body");
    }
    return guestRepository.save(guest);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.RESET_CONTENT)
  public void deleteGuestById(@PathVariable("id") long id) {
    guestRepository.deleteById(id);
  }
}
