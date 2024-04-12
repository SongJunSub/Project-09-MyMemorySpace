package mymemoryspace.backend.service.jpa;

import lombok.RequiredArgsConstructor;
import mymemoryspace.backend.dto.RoomMasterDto;
import mymemoryspace.backend.repository.jpa.RoomMasterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomMasterService {

    private final RoomMasterRepository roomMasterRepository;

    public List<RoomMasterDto> findRoomMaster(String roomTypeCode){
        final String activnYn = "Y";

        return roomMasterRepository.findRoomMaster(roomTypeCode, activnYn);
    }

}