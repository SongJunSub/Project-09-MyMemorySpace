package mymemoryspace.backend.service.jpa;

import lombok.RequiredArgsConstructor;
import mymemoryspace.backend.dto.ReservationCondition;
import mymemoryspace.backend.dto.ReservationDTO;
import mymemoryspace.backend.entity.customer.Customer;
import mymemoryspace.backend.entity.reservation.Reservation;
import mymemoryspace.backend.entity.reservation.ReservationRoomRate;
import mymemoryspace.backend.repository.jpa.CustomerRepository;
import mymemoryspace.backend.repository.jpa.ReservationRepository;
import mymemoryspace.backend.repository.jpa.ReservationRoomRateRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final CustomerRepository customerRepository;
    private final ReservationRoomRateRepository reservationRoomRateRepository;

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

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        LocalDate arrivalDate = LocalDate.parse(reservationCondition.getArrivalDate(), dateTimeFormatter);
        LocalDate departureDate = LocalDate.parse(reservationCondition.getDepartureDate(), dateTimeFormatter);

        final int nights = (int) Math.abs(ChronoUnit.DAYS.between(arrivalDate, departureDate));

        if(nights == reservationCondition.getNights()){
            while(arrivalDate.isBefore(departureDate.minusDays(1))){
                String stayDate = arrivalDate.format(dateTimeFormatter);

                ReservationRoomRate reservationRoomRate = new ReservationRoomRate(
                        reservation,
                        stayDate,
                        reservationCondition.getRoomTypeCode(),
                        reservationCondition.getRoomRate()
                );

                reservationRoomRateRepository.save(reservationRoomRate);

                arrivalDate = arrivalDate.plusDays(1);
            }
        }

        return null;
    }

}