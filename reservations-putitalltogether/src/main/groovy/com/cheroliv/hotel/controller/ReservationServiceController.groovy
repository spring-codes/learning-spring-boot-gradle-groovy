package com.cheroliv.hotel.controller

import com.cheroliv.hotel.dto.RoomReservation
import com.cheroliv.hotel.service.ReservationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "/api")
class ReservationServiceController {

    final ReservationService reservationService

    @Autowired
    ReservationServiceController(ReservationService reservationService) {
        this.reservationService = reservationService
    }

    @RequestMapping(method = RequestMethod.GET, value = "/reservations/{date}")
    List<RoomReservation> getAllReservationsForDate(@PathVariable(value = "date") String dateString) {
        return this.reservationService.getRoomReservationsForDate(dateString)
    }
}
