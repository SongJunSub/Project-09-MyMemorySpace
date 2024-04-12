package mymemoryspace.backend.service.jpa;

import lombok.RequiredArgsConstructor;
import mymemoryspace.backend.dto.RoomTypeDto;
import mymemoryspace.backend.repository.jpa.RoomTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomTypeService {

    private final RoomTypeRepository roomTypeRepository;

    public List<RoomTypeDto> findRoomType(){
        String activnYn = "Y";

        return roomTypeRepository.findRoomType(activnYn);
    }

}