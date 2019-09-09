package com.cheroliv.hotel.domain

import javax.persistence.*

@Entity
@Table(name = "GUEST")
class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "GUEST_ID")
     long id
    @Column(name = "FIRST_NAME")
     String firstName
    @Column(name = "LAST_NAME")
     String lastName
    @Column(name = "EMAIL_ADDRESS")
     String emailAddress
    @Column(name = "ADDRESS")
     String address
    @Column(name = "COUNTRY")
     String country
    @Column(name = "STATE")
     String state
    @Column(name = "PHONE_NUMBER")
     String phoneNumber


}