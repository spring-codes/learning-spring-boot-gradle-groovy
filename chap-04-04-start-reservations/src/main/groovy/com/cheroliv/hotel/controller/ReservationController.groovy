package com.cheroliv.hotel.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import groovy.transform.CompileStatic

@Controller
@CompileStatic
@RequestMapping(value = "/reservations")
class ReservationController {

    @RequestMapping(method = RequestMethod.GET)
    String getReservations() {
        return "reservations"
    }
}
