package com.projectairlines.reservationservice.controller;


import com.projectairlines.reservationservice.VO.ResponseTemplateVO;
import com.projectairlines.reservationservice.model.Reservation;
import com.projectairlines.reservationservice.service.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
@Slf4j
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/test")
    public String test(){
        log.info("ReservationController Work!");
        return "test";
    }

    @PostMapping("/")
    public Reservation saveReservation(@RequestBody Reservation reservation){
        log.info("Inside ReservationController: saveReservation");
        return reservationService.saveReservation(reservation);
    }

    @GetMapping("/{id}")
    public Reservation findReservationById(@PathVariable("id") Long reservationId){
        log.info("Inside ReservationController: findReservationById");
        return reservationService.findReservationById(reservationId);
    }

    @GetMapping("/user-id/{id}")
    public ResponseTemplateVO getReservationWithFlight(@PathVariable("id") Long userId){
        log.info("Inside ReservationController: findReservationsByUserId");
        return reservationService.findReservationsByUserId(userId);
    }

}
