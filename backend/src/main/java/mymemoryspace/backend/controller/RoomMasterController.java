package mymemoryspace.backend.controller;

import lombok.RequiredArgsConstructor;
import mymemoryspace.backend.dto.RoomMasterDto;
import mymemoryspace.backend.service.jpa.RoomMasterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RoomMasterController {

    private final RoomMasterService roomMasterService;

    @GetMapping("/api/availableRoomNo")
    public List<RoomMasterDto> findRoomMaster(@RequestParam String roomTypeCode){
        return roomMasterService.findRoomMaster(roomTypeCode);
    }

}