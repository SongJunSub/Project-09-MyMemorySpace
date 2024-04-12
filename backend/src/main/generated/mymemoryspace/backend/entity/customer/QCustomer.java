package mymemoryspace.backend.entity.customer;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCustomer is a Querydsl query type for Customer
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCustomer extends EntityPathBase<Customer> {

    private static final long serialVersionUID = -361815886L;

    public static final QCustomer customer = new QCustomer("customer");

    public final StringPath activeYn = createString("activeYn");

    public final StringPath birthDate = createString("birthDate");

    public final StringPath blackListYn = createString("blackListYn");

    public final StringPath customerName = createString("customerName");

    public final NumberPath<Long> customerNo = createNumber("customerNo", Long.class);

    public final StringPath email = createString("email");

    public final StringPath mobileNo = createString("mobileNo");

    public final ListPath<mymemoryspace.backend.entity.reservation.Reservation, mymemoryspace.backend.entity.reservation.QReservation> reservations = this.<mymemoryspace.backend.entity.reservation.Reservation, mymemoryspace.backend.entity.reservation.QReservation>createList("reservations", mymemoryspace.backend.entity.reservation.Reservation.class, mymemoryspace.backend.entity.reservation.QReservation.class, PathInits.DIRECT2);

    public final NumberPath<Integer> visitCount = createNumber("visitCount", Integer.class);

    public QCustomer(String variable) {
        super(Customer.class, forVariable(variable));
    }

    public QCustomer(Path<? extends Customer> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCustomer(PathMetadata metadata) {
        super(Customer.class, metadata);
    }

}

