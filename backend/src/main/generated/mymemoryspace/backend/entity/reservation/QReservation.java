package mymemoryspace.backend.entity.reservation;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReservation is a Querydsl query type for Reservation
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReservation extends EntityPathBase<Reservation> {

    private static final long serialVersionUID = -1042785746L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReservation reservation = new QReservation("reservation");

    public final StringPath address = createString("address");

    public final StringPath arrivalDate = createString("arrivalDate");

    public final StringPath birthDate = createString("birthDate");

    public final mymemoryspace.backend.entity.customer.QCustomer customer;

    public final StringPath departureDate = createString("departureDate");

    public final StringPath detailAddress = createString("detailAddress");

    public final StringPath email = createString("email");

    public final StringPath mobileNo = createString("mobileNo");

    public final NumberPath<Integer> nights = createNumber("nights", Integer.class);

    public final StringPath reservationDate = createString("reservationDate");

    public final StringPath reservationName = createString("reservationName");

    public final NumberPath<Long> reservationNo = createNumber("reservationNo", Long.class);

    public final ListPath<ReservationRoomRate, QReservationRoomRate> reservationRoomRates = this.<ReservationRoomRate, QReservationRoomRate>createList("reservationRoomRates", ReservationRoomRate.class, QReservationRoomRate.class, PathInits.DIRECT2);

    public final ListPath<ReservationServiceRate, QReservationServiceRate> reservationServiceRates = this.<ReservationServiceRate, QReservationServiceRate>createList("reservationServiceRates", ReservationServiceRate.class, QReservationServiceRate.class, PathInits.DIRECT2);

    public final StringPath roomNo = createString("roomNo");

    public final EnumPath<ReservationStatusCode> rsvnStatusCode = createEnum("rsvnStatusCode", ReservationStatusCode.class);

    public QReservation(String variable) {
        this(Reservation.class, forVariable(variable), INITS);
    }

    public QReservation(Path<? extends Reservation> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReservation(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReservation(PathMetadata metadata, PathInits inits) {
        this(Reservation.class, metadata, inits);
    }

    public QReservation(Class<? extends Reservation> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.customer = inits.isInitialized("customer") ? new mymemoryspace.backend.entity.customer.QCustomer(forProperty("customer")) : null;
    }

}

