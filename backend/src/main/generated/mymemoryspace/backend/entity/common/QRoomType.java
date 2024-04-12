package mymemoryspace.backend.entity.common;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QRoomType is a Querydsl query type for RoomType
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRoomType extends EntityPathBase<RoomType> {

    private static final long serialVersionUID = -551981796L;

    public static final QRoomType roomType = new QRoomType("roomType");

    public final StringPath activeYn = createString("activeYn");

    public final NumberPath<Integer> roomCount = createNumber("roomCount", Integer.class);

    public final StringPath roomTypeCode = createString("roomTypeCode");

    public final NumberPath<Long> roomTypeId = createNumber("roomTypeId", Long.class);

    public final StringPath roomTypeName = createString("roomTypeName");

    public final NumberPath<Integer> standardRoomRate = createNumber("standardRoomRate", Integer.class);

    public QRoomType(String variable) {
        super(RoomType.class, forVariable(variable));
    }

    public QRoomType(Path<? extends RoomType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoomType(PathMetadata metadata) {
        super(RoomType.class, metadata);
    }

}

