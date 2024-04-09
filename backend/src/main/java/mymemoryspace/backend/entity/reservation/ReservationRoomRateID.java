package mymemoryspace.backend.entity.reservation;

import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class ReservationRoomRateID implements Serializable {

    @Column(name = "reservation_no")
    private Long reservationNo;

    private Long roomRateSeqNo;

}