package com.cheroliv.hotel.service

import com.cheroliv.hotel.domain.Guest
import com.cheroliv.hotel.domain.Reservation
import com.cheroliv.hotel.domain.Room
import com.cheroliv.hotel.dto.RoomReservation
import com.cheroliv.hotel.repository.GuestRepository
import com.cheroliv.hotel.repository.ReservationRepository
import com.cheroliv.hotel.repository.RoomRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.util.function.Consumer

@Service
class ReservationService {
    final RoomRepository roomRepository
    final GuestRepository guestRepository
    final ReservationRepository reservationRepository

    @Autowired
    ReservationService(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository
        this.guestRepository = guestRepository
        this.reservationRepository = reservationRepository
    }

    List<RoomReservation> getRoomReservationsForDate(Date date) {
        Iterable<Room> rooms = this.roomRepository.findAll()
        Map<Long, RoomReservation> roomReservationMap = new HashMap<>()
        rooms.forEach(new Consumer<Room>() {
            @Override
            void accept(Room room) {
                RoomReservation roomReservation = new RoomReservation()
                roomReservation.setRoomId(room.getId())
                roomReservation.setRoomName(room.getName())
                roomReservation.setRoomNumber(room.getNumber())
                roomReservationMap.put(room.getId(), roomReservation)
            }
        })
        Iterable<Reservation> reservations = this.reservationRepository.findByDate(new java.sql.Date(date.getTime()))
        if (null != reservations) {
            reservations.forEach(new Consumer<Reservation>() {
                @Override
                void accept(Reservation reservation) {
                    Optional<Guest> optionalGuest = ReservationService.this.guestRepository.findById(reservation.getGuestId())
                    assert optionalGuest.isPresent()
                    Guest guest = optionalGuest.get()
                    if (null != guest) {
                        RoomReservation roomReservation = roomReservationMap.get(reservation.getId())
                        roomReservation.setDate(date)
                        roomReservation.setFirstName(guest.getFirstName())
                        roomReservation.setLastName(guest.getLastName())
                        roomReservation.setGuestId(guest.getId())
                    }
                }
            })
        }
        List<RoomReservation> roomReservations = new ArrayList<>()
        for (Long roomId : roomReservationMap.keySet()) {
            roomReservations.add(roomReservationMap.get(roomId))
        }
        return roomReservations
    }
}
