package mymemoryspace.backend.controller;

import lombok.RequiredArgsConstructor;
import mymemoryspace.backend.dto.RoomMasterDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RoomMasterController {

    @GetMapping("/api/roomMaster")
    public List<RoomMasterDto> selectRoomMaster(){
        return null;
    }

}