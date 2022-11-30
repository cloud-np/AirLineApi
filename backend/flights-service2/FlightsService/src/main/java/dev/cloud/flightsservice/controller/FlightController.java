package dev.cloud.flightsservice.controller;

import dev.cloud.flightsservice.model.Flight;
import dev.cloud.flightsservice.service.FlightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flights")
@Slf4j
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/test")
    public String test(){
        log.info("FlightController Works!");
        return "test";
    }

    @PostMapping("/")
    public Flight saveFlight(@RequestBody Flight flight){
        log.info("Inside FlightController: saveFlight");
        return flightService.saveFlight(flight);
    }

    @GetMapping("/{id}")
    public Flight findFlightById(@PathVariable("id") Long flightId){
        log.info("Inside FlightController: findFlightById");
        return flightService.findFlightById(flightId);
    }
}
