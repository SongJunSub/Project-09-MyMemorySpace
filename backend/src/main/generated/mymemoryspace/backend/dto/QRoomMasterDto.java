package mymemoryspace.backend.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * mymemoryspace.backend.dto.QRoomMasterDto is a Querydsl Projection type for RoomMasterDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QRoomMasterDto extends ConstructorExpression<RoomMasterDto> {

    private static final long serialVersionUID = 818164868L;

    public QRoomMasterDto(com.querydsl.core.types.Expression<String> roomNo, com.querydsl.core.types.Expression<String> roomTypeName) {
        super(RoomMasterDto.class, new Class<?>[]{String.class, String.class}, roomNo, roomTypeName);
    }

}

