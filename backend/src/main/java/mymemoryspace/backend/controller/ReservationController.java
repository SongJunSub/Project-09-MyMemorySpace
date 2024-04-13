package mymemoryspace.backend.controller;

import lombok.RequiredArgsConstructor;
import mymemoryspace.backend.dto.ReservationCondition;
import mymemoryspace.backend.dto.ReservationDTO;
import mymemoryspace.backend.service.jpa.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("/api/saveReservation")
    public ResponseEntity<ReservationDTO> saveReservation(@RequestBody ReservationCondition reservationCondition){
        ReservationDTO result = reservationService.saveReservation(reservationCondition);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

}