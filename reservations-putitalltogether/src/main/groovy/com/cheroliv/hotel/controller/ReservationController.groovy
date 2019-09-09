package com.cheroliv.hotel.controller

import com.cheroliv.hotel.dto.RoomReservation
import com.cheroliv.hotel.service.ReservationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping(value = "/reservations")
class ReservationController {


    final ReservationService reservationService

    @Autowired
    ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService
    }


    @RequestMapping(method = RequestMethod.GET)
    String getReservations(
            @RequestParam(value = "date", required = false)
                    String dateString,
            Model model) {
        List<RoomReservation> roomReservationList = this.reservationService.getRoomReservationsForDate(dateString)
        model.addAttribute("roomReservations", roomReservationList)
        return "reservations"
    }
}
