package com.frankmoley.lil.landonhotel.data.repository;

import com.frankmoley.lil.landonhotel.data.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
}
