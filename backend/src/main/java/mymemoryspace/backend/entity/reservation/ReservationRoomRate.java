package mymemoryspace.backend.entity.reservation;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReservationRoomRate {

    @EmbeddedId
    private ReservationRoomRateID roomRateId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_no", insertable = false, updatable = false)
    private Reservation reservation;

    @Column(length = 8)
    private String stayDate;

    private String roomTypeCode;

    private int roomRate;

}