package mymemoryspace.backend.entity.reservation;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReservationRoomRate is a Querydsl query type for ReservationRoomRate
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReservationRoomRate extends EntityPathBase<ReservationRoomRate> {

    private static final long serialVersionUID = 380570793L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReservationRoomRate reservationRoomRate = new QReservationRoomRate("reservationRoomRate");

    public final QReservation reservation;

    public final NumberPath<Integer> roomRate = createNumber("roomRate", Integer.class);

    public final NumberPath<Long> roomRateId = createNumber("roomRateId", Long.class);

    public final StringPath roomTypeCode = createString("roomTypeCode");

    public final StringPath stayDate = createString("stayDate");

    public QReservationRoomRate(String variable) {
        this(ReservationRoomRate.class, forVariable(variable), INITS);
    }

    public QReservationRoomRate(Path<? extends ReservationRoomRate> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReservationRoomRate(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReservationRoomRate(PathMetadata metadata, PathInits inits) {
        this(ReservationRoomRate.class, metadata, inits);
    }

    public QReservationRoomRate(Class<? extends ReservationRoomRate> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.reservation = inits.isInitialized("reservation") ? new QReservation(forProperty("reservation"), inits.get("reservation")) : null;
    }

}

