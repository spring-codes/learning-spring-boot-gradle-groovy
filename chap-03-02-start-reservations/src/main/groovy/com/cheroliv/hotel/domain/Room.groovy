package com.cheroliv.hotel.domain

import javax.persistence.*

@Entity
@Table(name = "ROOM")
class Room {
    @Id
    @Column(name = "ROOM_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id
    @Column(name = "NAME")
    private String name
    @Column(name = "ROOM_NUMBER")
    private String number
    @Column(name = "BED_INFO")
    private String bedInfo
}
