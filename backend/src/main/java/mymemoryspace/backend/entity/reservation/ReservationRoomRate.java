package mymemoryspace.backend.entity.reservation;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReservationRoomRate {

    @Id
    @GeneratedValue
    private Long roomRateId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservationNo")
    private Reservation reservation;

    @Column(length = 8, unique = true)
    private String stayDate;

    private String roomTypeCode;

    private int roomRate;

    public ReservationRoomRate(Reservation reservation, String stayDate, String roomTypeCode, int roomRate){
        if(reservation != null){
            changeReservation(reservation);
        }

        this.stayDate = stayDate;
        this.roomTypeCode = roomTypeCode;
        this.roomRate = roomRate;
    }

    private void changeReservation(Reservation reservation){
        this.reservation = reservation;
        reservation.getReservationRoomRates().add(this);
    }

}