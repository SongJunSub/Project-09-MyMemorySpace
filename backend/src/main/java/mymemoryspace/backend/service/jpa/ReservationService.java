package mymemoryspace.backend.service.jpa;

import lombok.RequiredArgsConstructor;
import mymemoryspace.backend.dto.ReservationCondition;
import mymemoryspace.backend.dto.ReservationDTO;
import mymemoryspace.backend.entity.customer.Customer;
import mymemoryspace.backend.entity.reservation.Reservation;
import mymemoryspace.backend.repository.jpa.CustomerRepository;
import mymemoryspace.backend.repository.jpa.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final CustomerRepository customerRepository;

    @Transactional
    public ReservationDTO saveReservation(ReservationCondition reservationCondition) {
        Customer customer = new Customer(
                reservationCondition.getReservationName(),
                reservationCondition.getBirthDate(),
                reservationCondition.getMobileNo(),
                reservationCondition.getEmail(),
                1,
                "N",
                "Y"
        );

        Reservation reservation = new Reservation(
                reservationCondition.getReservationName(),
                reservationCondition.getArrivalDate(),
                reservationCondition.getDepartureDate(),
                reservationCondition.getNights(),
                reservationCondition.getRoomNo(),
                customer
        );

        customerRepository.save(customer);
        reservationRepository.save(reservation);

        return null;
    }

}