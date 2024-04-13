package mymemoryspace.backend.entity.customer;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mymemoryspace.backend.entity.reservation.Reservation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer {

    @Id
    @GeneratedValue
    private Long customerNo;

    private String customerName;

    @Column(length = 8)
    private String birthDate;

    private String mobileNo;

    private String email;

    private int visitCount;

    private String blackListYn;

    private String activeYn;

    @OneToMany(mappedBy = "customer")
    private List<Reservation> reservations = new ArrayList<>();

    public Customer(String customerName, String birthDate, String mobileNo, String email, int visitCount, String blackListYn, String activeYn){
        this.customerName = customerName;
        this.birthDate = birthDate;
        this.mobileNo = mobileNo;
        this.email = email;
        this.visitCount = visitCount;
        this.blackListYn = blackListYn;
        this.activeYn = activeYn;
    }

}