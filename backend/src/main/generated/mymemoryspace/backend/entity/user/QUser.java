package mymemoryspace.backend.entity.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -1275918126L;

    public static final QUser user = new QUser("user");

    public final EnumPath<UserLevel> accessLevel = createEnum("accessLevel", UserLevel.class);

    public final StringPath activeYn = createString("activeYn");

    public final StringPath birthDate = createString("birthDate");

    public final StringPath email = createString("email");

    public final StringPath mobileNo = createString("mobileNo");

    public final StringPath password = createString("password");

    public final StringPath userId = createString("userId");

    public final StringPath userName = createString("userName");

    public final NumberPath<Long> userNo = createNumber("userNo", Long.class);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

