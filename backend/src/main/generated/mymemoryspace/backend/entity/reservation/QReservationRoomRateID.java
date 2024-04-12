package mymemoryspace.backend.entity.reservation;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QReservationRoomRateID is a Querydsl query type for ReservationRoomRateID
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QReservationRoomRateID extends BeanPath<ReservationRoomRateID> {

    private static final long serialVersionUID = 656314244L;

    public static final QReservationRoomRateID reservationRoomRateID = new QReservationRoomRateID("reservationRoomRateID");

    public final NumberPath<Long> reservationNo = createNumber("reservationNo", Long.class);

    public final NumberPath<Long> roomRateSeqNo = createNumber("roomRateSeqNo", Long.class);

    public QReservationRoomRateID(String variable) {
        super(ReservationRoomRateID.class, forVariable(variable));
    }

    public QReservationRoomRateID(Path<? extends ReservationRoomRateID> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReservationRoomRateID(PathMetadata metadata) {
        super(ReservationRoomRateID.class, metadata);
    }

}

