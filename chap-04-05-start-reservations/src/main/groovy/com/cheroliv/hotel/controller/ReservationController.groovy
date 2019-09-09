package com.cheroliv.hotel.controller

import com.cheroliv.hotel.dto.RoomReservation
import com.cheroliv.hotel.service.ReservationService
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat

@Controller
@CompileStatic
@RequestMapping(value = "/reservations")
class ReservationController {

    static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd")

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
        Date date = null
        if (null != dateString) {
            try {
                date = DATE_FORMAT.parse(dateString)
            } catch (ParseException pe) {
                date = new Date()
            }
        } else {
            date = new Date()
        }
        List<RoomReservation> roomReservationList =
                this.reservationService
                        .getRoomReservationsForDate(date)
        model.addAttribute(
                "roomReservations",
                roomReservationList)
        return "reservations"
    }
}
