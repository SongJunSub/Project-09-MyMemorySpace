package mymemoryspace.backend.entity.common;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QServiceType is a Querydsl query type for ServiceType
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QServiceType extends EntityPathBase<ServiceType> {

    private static final long serialVersionUID = -296375352L;

    public static final QServiceType serviceType = new QServiceType("serviceType");

    public final StringPath activeYn = createString("activeYn");

    public final NumberPath<Integer> quantity = createNumber("quantity", Integer.class);

    public final StringPath serviceTypeCode = createString("serviceTypeCode");

    public final NumberPath<Long> serviceTypeId = createNumber("serviceTypeId", Long.class);

    public final StringPath serviceTypeName = createString("serviceTypeName");

    public final NumberPath<Integer> standardServiceRate = createNumber("standardServiceRate", Integer.class);

    public QServiceType(String variable) {
        super(ServiceType.class, forVariable(variable));
    }

    public QServiceType(Path<? extends ServiceType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QServiceType(PathMetadata metadata) {
        super(ServiceType.class, metadata);
    }

}

