package mymemoryspace.backend.repository.jpa;

import mymemoryspace.backend.entity.reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {



}