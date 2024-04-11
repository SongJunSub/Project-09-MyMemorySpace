package mymemoryspace.backend.entity.common;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class RoomMaster {

    @Id
    @GeneratedValue
    private Long roomMasterId;

    private String roomNo;

    private String roomTypeCode;

    private int floor;

    private String activeYn;

}