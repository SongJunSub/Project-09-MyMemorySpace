package mymemoryspace.backend.entity.reservation;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mymemoryspace.backend.entity.customer.Customer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    @Column(length = 8)
    private String arrivalDate;

    @Column(length = 8)
    private String departureDate;

    private int nights;

    private String roomNo;

    @Column(length = 8)
    private String reservationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_no")
    private Customer customer;

    @Enumerated(EnumType.STRING)
    private ReservationStatusCode rsvnStatusCode;

    @OneToMany(mappedBy = "reservation")
    private List<ReservationRoomRate> reservationRoomRates = new ArrayList<>();

    @OneToMany(mappedBy = "reservation")
    private List<ReservationServiceRate> reservationServiceRates = new ArrayList<>();

    public Reservation(String reservationName, String arrivalDate, String departureDate, int nights, String roomNo, Customer customer){
        this.reservationName = reservationName;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.nights = nights;
        this.roomNo = roomNo;

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        this.reservationDate = currentDate.format(dateTimeFormatter);
        this.rsvnStatusCode = ReservationStatusCode.RR;

        if(customer != null){
            changeCustomer(customer);
        }
    }

    private void changeCustomer(Customer customer){
        this.customer = customer;
        customer.getReservations().add(this);
    }

}