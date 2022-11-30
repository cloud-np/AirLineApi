package com.projectairlines.reservationservice.VO;

import com.projectairlines.reservationservice.model.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private List<Reservation> reservations;
    private List<Flight> flights;
}
