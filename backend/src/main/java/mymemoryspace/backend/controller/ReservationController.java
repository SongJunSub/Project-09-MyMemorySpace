package mymemoryspace.backend.controller;

import mymemoryspace.backend.dto.ReservationCondition;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {

    @PostMapping("/api/saveReservation")
    public void saveReservation(@RequestBody ReservationCondition reservationCondition){
        System.out.println(reservationCondition);
    }

}