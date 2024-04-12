package mymemoryspace.backend.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoomMasterDto {

    private String roomNo;
    private String roomTypeCode;

    @QueryProjection
    public RoomMasterDto(String roomNo, String roomTypeName){
        this.roomNo = roomNo;
        this.roomTypeCode = roomTypeCode;
    }

}