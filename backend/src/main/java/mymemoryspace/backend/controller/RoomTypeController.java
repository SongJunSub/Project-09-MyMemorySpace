package mymemoryspace.backend.controller;

import lombok.RequiredArgsConstructor;
import mymemoryspace.backend.dto.RoomTypeDto;
import mymemoryspace.backend.service.jpa.RoomTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RoomTypeController {

    private final RoomTypeService roomTypeService;

    @GetMapping("/api/roomType")
    public List<RoomTypeDto> findRoomType(){
        return roomTypeService.findRoomType();
    }

}