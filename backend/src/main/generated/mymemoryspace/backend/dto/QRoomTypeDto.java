package mymemoryspace.backend.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * mymemoryspace.backend.dto.QRoomTypeDto is a Querydsl Projection type for RoomTypeDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QRoomTypeDto extends ConstructorExpression<RoomTypeDto> {

    private static final long serialVersionUID = -1987678612L;

    public QRoomTypeDto(com.querydsl.core.types.Expression<String> roomTypeCode, com.querydsl.core.types.Expression<String> roomTypeName, com.querydsl.core.types.Expression<Integer> standardRoomRate) {
        super(RoomTypeDto.class, new Class<?>[]{String.class, String.class, int.class}, roomTypeCode, roomTypeName, standardRoomRate);
    }

}

