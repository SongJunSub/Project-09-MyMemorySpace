package mymemoryspace.backend.dto;

import lombok.Data;

@Data
public class ReservationCondition {

    private String reservationName;

    private String arrivalDate;

    private String departureDate;

    private int nights;

    private String roomTypeCode;

    private String roomNo;

    private int roomRate;

    private String birthDate;

    private String mobileNo;

    private String email;

    private String address;

    private String detailAddress;

}