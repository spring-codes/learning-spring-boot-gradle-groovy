package com.cheroliv.hotel.domain

import javax.persistence.*

@Entity
@Table(name = "ROOM")
class Room {
    @Id
    @Column(name = "ROOM_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id
    @Column(name = "NAME")
    String name
    @Column(name = "ROOM_NUMBER")
    String number
    @Column(name = "BED_INFO")
    String bedInfo
}
