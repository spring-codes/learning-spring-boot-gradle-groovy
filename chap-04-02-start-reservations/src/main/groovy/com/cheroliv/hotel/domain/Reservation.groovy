package com.cheroliv.hotel.domain

import javax.persistence.*
import java.sql.Date

@Entity
@Table(name = "RESERVATION")
class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RESERVATION_ID")
    long id
    @Column(name = "ROOM_ID")
    long roomId
    @Column(name = "GUEST_ID")
    long guestId
    @Column(name = "RES_DATE")
    Date date

}