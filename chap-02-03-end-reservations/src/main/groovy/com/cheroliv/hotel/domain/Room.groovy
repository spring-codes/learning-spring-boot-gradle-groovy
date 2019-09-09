package com.cheroliv.hotel.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="ROOM")
class Room {
    @Id
    @Column(name="ROOM_ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    long id
    @Column(name="NAME")
    String name
    @Column(name="ROOM_NUMBER")
    String number
    @Column(name="BED_INFO")
    String bedInfo
}
