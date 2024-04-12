package mymemoryspace.backend.entity.reservation;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QReservationServiceRateID is a Querydsl query type for ReservationServiceRateID
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QReservationServiceRateID extends BeanPath<ReservationServiceRateID> {

    private static final long serialVersionUID = 1033700738L;

    public static final QReservationServiceRateID reservationServiceRateID = new QReservationServiceRateID("reservationServiceRateID");

    public final NumberPath<Long> reservationNo = createNumber("reservationNo", Long.class);

    public final NumberPath<Long> serviceRateSeqNo = createNumber("serviceRateSeqNo", Long.class);

    public QReservationServiceRateID(String variable) {
        super(ReservationServiceRateID.class, forVariable(variable));
    }

    public QReservationServiceRateID(Path<? extends ReservationServiceRateID> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReservationServiceRateID(PathMetadata metadata) {
        super(ReservationServiceRateID.class, metadata);
    }

}

