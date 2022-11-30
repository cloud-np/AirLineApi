package com.projectairlines.reservationservice.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    private Long flightId;
    private String flightDate;
    private double price;
    private String airLineName;
    private String transitDate;
    private int layover;
    private String scale;
    private boolean luggage;

    @Override
    public String toString() {
        return "Flight{" +
                "flightId=" + flightId +
                ", flightDate='" + flightDate + '\'' +
                ", price=" + price +
                ", airLineName='" + airLineName + '\'' +
                ", transitDate='" + transitDate + '\'' +
                ", layover=" + layover +
                ", scale='" + scale + '\'' +
                ", luggage=" + luggage +
                '}';
    }
}
