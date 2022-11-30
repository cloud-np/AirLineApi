package com.projectairlines.reservationservice.reposity;


import com.projectairlines.reservationservice.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Reservation findByReservationId(Long reservationId);

    List<Reservation> findReservationsByUserId(Long userId);
}
