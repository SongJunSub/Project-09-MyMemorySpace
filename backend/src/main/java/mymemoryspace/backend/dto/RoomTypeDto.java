package mymemoryspace.backend.dto;

import com.querydsl.core.annotations.QueryProjection;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoomTypeDto {

    private String roomTypeCode;

    private String roomTypeName;

    private int standardRoomRate;

    @QueryProjection
    public RoomTypeDto(String roomTypeCode, String roomTypeName, int standardRoomRate){
        this.roomTypeCode = roomTypeCode;
        this.roomTypeName = roomTypeName;
        this.standardRoomRate = standardRoomRate;
    }

}