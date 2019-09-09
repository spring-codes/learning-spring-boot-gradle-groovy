package com.cheroliv.hotel.repository

import com.cheroliv.hotel.domain.Guest
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface GuestRepository extends PagingAndSortingRepository<Guest, Long> {

}