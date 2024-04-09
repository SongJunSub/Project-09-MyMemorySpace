package mymemoryspace.backend.entity.common;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mymemoryspace.backend.entity.reservation.ReservationServiceRate;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ServiceType {

    @Id
    @GeneratedValue
    private Long serviceTypeId;

    @Column(unique = true)
    private String serviceTypeCode;

    private String serviceTypeName;

    private int standardServiceRate;

    private int quantity;

    private String activeYn;

}