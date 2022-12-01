package dev.cloud.flightsservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long flightId;
    @Temporal(TemporalType.TIMESTAMP)
    private String flightDate;
    private double price;
    private String airLineName;
    @Temporal(TemporalType.TIMESTAMP)
    private String transitDate;
    private String startPos;
    private String endPos;
    private int layover;
    private String scale;
    private boolean luggage;
}
