package com.projectairlines.cloudgateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/userServiceFallBack")
    public String userServiceFallBackMethod(){
        return "User Service is taking longer than Expected." +
                " Please try again later";
    }

    @GetMapping("/flightServiceFallBack")
    public String flightServiceFallBackMethod(){
        return "Flight Service is taking longer than Expected." +
                " Please try again later";
    }
}
