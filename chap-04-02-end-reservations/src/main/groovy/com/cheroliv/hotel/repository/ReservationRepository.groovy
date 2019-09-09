package com.cheroliv.hotel.repository

import com.cheroliv.hotel.domain.Reservation
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

import java.sql.Date

@Repository
interface ReservationRepository extends CrudRepository<Reservation, Long> {
    List<Reservation> findByDate(Date date)
}