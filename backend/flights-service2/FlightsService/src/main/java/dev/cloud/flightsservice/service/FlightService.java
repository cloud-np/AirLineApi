package dev.cloud.flightsservice.service;

import dev.cloud.flightsservice.model.Flight;
import dev.cloud.flightsservice.reposity.FlightRepository;
import jakarta.annotation.PostConstruct;
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

    @PostConstruct
    public void initEntities(){
        flightRepository.save(new Flight((long)1, "2022-12-20 13:19:27", 430, "Iberia", "2022-12-20 19:25:00", 2, "Economy", false));
        flightRepository.save(new Flight((long)2, "2022-12-18 08:30:00", 89, "Aegean", "2022-12-18 22:00:00", 1, "Economy", true));
        flightRepository.save(new Flight((long)3, "2022-12-19 18:15:00", 789, "Aegean", "2022-12-18 23:45:00", 0, "Business", true));
        flightRepository.save(new Flight((long)4, "2022-12-24 18:15:00", 439, "Aegean", "2022-12-24 23:45:00", 0, "Business", true));
        flightRepository.save(new Flight((long)5, "2022-12-27 06:10:00", 813, "RyanAir", "2022-12-18 23:45:00", 0, "Business", true));
        flightRepository.save(new Flight((long)6, "2022-12-17 09:15:00", 79, "RyanAir", "2022-12-18 13:45:00", 1, "Economy", false));
    }
}
