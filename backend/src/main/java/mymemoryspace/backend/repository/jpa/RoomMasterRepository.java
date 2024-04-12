package mymemoryspace.backend.repository.jpa;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import mymemoryspace.backend.dto.QRoomMasterDto;
import mymemoryspace.backend.dto.RoomMasterDto;
import org.springframework.stereotype.Repository;

import java.util.List;

import static mymemoryspace.backend.entity.common.QRoomMaster.roomMaster;

@Repository
public class RoomMasterRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public RoomMasterRepository(EntityManager entityManager){
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    public List<RoomMasterDto> findRoomMaster(String roomTypeCode, String activnYn) {
        return jpaQueryFactory
                .select(new QRoomMasterDto(
                        roomMaster.roomNo,
                        roomMaster.roomTypeCode
                ))
                .from(roomMaster)
                .where(
                        roomTypeCodeEq(roomTypeCode),
                        activeYnEq(activnYn)
                )
                .fetch();
    }

    private BooleanExpression roomTypeCodeEq(String roomTypeCode){

        return roomTypeCode != null ? roomMaster.roomTypeCode.eq(roomTypeCode) : null;

    }

    private BooleanExpression activeYnEq(String activeYn){

        return activeYn != null ? roomMaster.activeYn.eq(activeYn) : null;

    }

}