package com.cheroliv.hotel.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.cheroliv.hotel.domain.Guest;
import org.springframework.stereotype.Repository;

@Repository
 interface GuestRepository extends PagingAndSortingRepository<Guest, Long> {

}