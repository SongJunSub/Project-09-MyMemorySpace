package mymemoryspace.backend.entity.reservation;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReservationServiceRate {

    @EmbeddedId
    private ReservationRoomRateID serviceRateId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_no", insertable = false, updatable = false)
    private Reservation reservation;

    @Column(length = 8)
    private String stayDate;

    private String serviceTypeCode;

    private int serviceRate;

    private int quantity;

}