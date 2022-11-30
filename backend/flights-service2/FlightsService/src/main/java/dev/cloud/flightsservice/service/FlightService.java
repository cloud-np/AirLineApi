package dev.cloud.flightsservice.service;

import dev.cloud.flightsservice.model.Flight;
import dev.cloud.flightsservice.reposity.FlightRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public Flight saveFlight(Flight flight){
        log.info("Inside UserService: saveUser");
        return flightRepository.save(flight);
    }

    public Flight findFlightById(Long flightId){
        log.info("Inside UserService: findFlightById");
        return flightRepository.findByFlightId(flightId);
    }
}
