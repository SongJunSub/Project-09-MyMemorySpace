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

    @Id
    @GeneratedValue
    private Long serviceRateId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservationNo")
    private Reservation reservation;

    @Column(length = 8)
    private String stayDate;

    private String serviceTypeCode;

    private int serviceRate;

    private int quantity;

}