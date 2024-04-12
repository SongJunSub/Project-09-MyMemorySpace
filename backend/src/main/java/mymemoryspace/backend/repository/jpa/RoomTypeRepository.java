package mymemoryspace.backend.repository.jpa;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import mymemoryspace.backend.dto.QRoomTypeDto;
import mymemoryspace.backend.dto.RoomTypeDto;
import org.springframework.stereotype.Repository;

import java.util.List;

import static mymemoryspace.backend.entity.common.QRoomType.roomType;

@Repository
public class RoomTypeRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public RoomTypeRepository(EntityManager entityManager){
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    public List<RoomTypeDto> findRoomType(String activeYn) {
        return jpaQueryFactory
                .select(new QRoomTypeDto(
                        roomType.roomTypeCode,
                        roomType.roomTypeName,
                        roomType.standardRoomRate
                ))
                .from(roomType)
                .where(
                        activeYnEq(activeYn)
                )
                .fetch();
    }

    private BooleanExpression activeYnEq(String activeYn){

        return activeYn != null ? roomType.activeYn.eq(activeYn) : null;

    }

}