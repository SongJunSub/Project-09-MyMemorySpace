package mymemoryspace.backend.entity.reservation;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mymemoryspace.backend.entity.customer.Customer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reservation {

    @Id
    @GeneratedValue
    private Long reservationNo;

    private String reservationName;

    private Date birthDate;

    private String mobileNo;

    private String email;

    private LocalDateTime reservationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_no")
    private Customer customer;

    @Enumerated(EnumType.STRING)
    private ReservationStatusCode rsvnStatusCode;

    @OneToMany(mappedBy = "reservation")
    private List<ReservationRoomRate> reservationRoomRates = new ArrayList<>();

    @OneToMany(mappedBy = "reservation")
    private List<ReservationServiceRate> reservationServiceRates = new ArrayList<>();

}