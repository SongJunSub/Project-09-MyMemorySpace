package mymemoryspace.backend.entity.common;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mymemoryspace.backend.entity.reservation.ReservationRoomRate;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoomType {

    @Id
    @GeneratedValue
    private Long roomTypeId;

    @Column(unique = true)
    private String roomTypeCode;

    private String roomTypeName;

    private int standardRoomRate;

    private String activeYn;

}