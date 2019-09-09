package com.cheroliv.hotel.repository;

import com.cheroliv.hotel.domain.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
 interface RoomRepository extends CrudRepository<Room, Long>{
    Room findByNumber(String number);
}
