package mymemoryspace.backend.entity.common;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QRoomMaster is a Querydsl query type for RoomMaster
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRoomMaster extends EntityPathBase<RoomMaster> {

    private static final long serialVersionUID = 1898977220L;

    public static final QRoomMaster roomMaster = new QRoomMaster("roomMaster");

    public final StringPath activeYn = createString("activeYn");

    public final NumberPath<Integer> floor = createNumber("floor", Integer.class);

    public final NumberPath<Long> roomMasterId = createNumber("roomMasterId", Long.class);

    public final StringPath roomNo = createString("roomNo");

    public final StringPath roomTypeCode = createString("roomTypeCode");

    public QRoomMaster(String variable) {
        super(RoomMaster.class, forVariable(variable));
    }

    public QRoomMaster(Path<? extends RoomMaster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoomMaster(PathMetadata metadata) {
        super(RoomMaster.class, metadata);
    }

}

