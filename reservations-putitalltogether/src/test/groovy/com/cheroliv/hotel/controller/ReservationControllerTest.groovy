package com.cheroliv.hotel.controller

import com.cheroliv.hotel.dto.RoomReservation
import com.cheroliv.hotel.service.ReservationService
import groovy.transform.CompileStatic
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc

import java.text.DateFormat
import java.text.SimpleDateFormat

import static org.hamcrest.CoreMatchers.containsString
import static org.mockito.BDDMockito.given
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@CompileStatic
@ExtendWith(SpringExtension)
@WebMvcTest(ReservationController)
class ReservationControllerTest {

    @MockBean
    ReservationService reservationService
    @Autowired
    MockMvc mockMvc

    static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd")

    @Test
    void getReservations() throws Exception {
        Date date = DATE_FORMAT.parse("2017-01-01")
        List<RoomReservation> mockReservationList = new ArrayList<>()
        RoomReservation mockRoomReservation = new RoomReservation()
        mockRoomReservation.setLastName("Test")
        mockRoomReservation.setFirstName("JUnit")
        mockRoomReservation.setDate(date)
        mockRoomReservation.setGuestId(1)
        mockRoomReservation.setRoomNumber("J1")
        mockRoomReservation.setRoomId(100)
        mockRoomReservation.setRoomName("JUnit Room")
        mockReservationList.add(mockRoomReservation)

        given(reservationService.getRoomReservationsForDate("2017-01-01")).willReturn(mockReservationList)
        this.mockMvc.perform(get("/reservations?date=2017-01-01")).andExpect(status().isOk()).andExpect(content().string(containsString("Test, JUnit")))
    }
}
