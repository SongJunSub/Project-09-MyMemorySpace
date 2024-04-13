package mymemoryspace.backend.entity.reservation;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReservationServiceRate is a Querydsl query type for ReservationServiceRate
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReservationServiceRate extends EntityPathBase<ReservationServiceRate> {

    private static final long serialVersionUID = -307303897L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReservationServiceRate reservationServiceRate = new QReservationServiceRate("reservationServiceRate");

    public final NumberPath<Integer> quantity = createNumber("quantity", Integer.class);

    public final QReservation reservation;

    public final NumberPath<Integer> serviceRate = createNumber("serviceRate", Integer.class);

    public final NumberPath<Long> serviceRateId = createNumber("serviceRateId", Long.class);

    public final StringPath serviceTypeCode = createString("serviceTypeCode");

    public final StringPath stayDate = createString("stayDate");

    public QReservationServiceRate(String variable) {
        this(ReservationServiceRate.class, forVariable(variable), INITS);
    }

    public QReservationServiceRate(Path<? extends ReservationServiceRate> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReservationServiceRate(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReservationServiceRate(PathMetadata metadata, PathInits inits) {
        this(ReservationServiceRate.class, metadata, inits);
    }

    public QReservationServiceRate(Class<? extends ReservationServiceRate> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.reservation = inits.isInitialized("reservation") ? new QReservation(forProperty("reservation"), inits.get("reservation")) : null;
    }

}

