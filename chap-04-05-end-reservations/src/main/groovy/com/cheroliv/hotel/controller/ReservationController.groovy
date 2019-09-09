package com.cheroliv.hotel.controller

import groovy.transform.CompileStatic
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
@CompileStatic
@RequestMapping(value = "/reservations")
class ReservationController {

    @RequestMapping(method = RequestMethod.GET)
    String getReservations() {
        return "reservations"
    }
}
