package com.projectairlines.reservationservice.service;


import com.projectairlines.reservationservice.VO.Flight;
import com.projectairlines.reservationservice.VO.ResponseTemplateVO;
import com.projectairlines.reservationservice.model.Reservation;
import com.projectairlines.reservationservice.reposity.ReservationRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@Slf4j
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RestTemplate restTemplate;


    public Reservation saveReservation(Reservation reservation){
        log.info("Inside ReservatioService: saveReservation");
        return reservationRepository.save(reservation);
    }

    public Reservation findReservationById(Long reservationId){
        log.info("Inside ReservationService: findReservationById");
        return reservationRepository.findByReservationId(reservationId);
    }

    public ResponseTemplateVO findReservationsByUserId(Long userId) {
        log.info("Inside ReservationService: findReservationsByUserId");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        List<Reservation> reservations = reservationRepository.findReservationsByUserId(userId);
        List<Flight> flights = new ArrayList<>();
        for (Reservation res : reservations){
            log.info("Flight ID: " + res.getFlightId());
            Flight flight = restTemplate.getForObject("http://FLIGHT-SERVICE/flights/" + res.getFlightId(), Flight.class);
            flights.add(flight);
        }
        log.info("" + flights.get(0));
        vo.setReservations(reservations);
        vo.setFlights(flights);
        return vo;
    }

    @PostConstruct
    public void initEntities(){
        reservationRepository.save(new Reservation((long)1, 309, (long)4, (long)2, 2));
        reservationRepository.save(new Reservation((long)2, 309, (long)4, (long)1, 2));
        reservationRepository.save(new Reservation((long)3, 309, (long)5, (long)2, 2));
        reservationRepository.save(new Reservation((long)4, 309, (long)4, (long)5, 2));
    }
}
