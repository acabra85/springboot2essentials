package com.acabra.webapp.service;

import com.acabra.webapp.model.Room;
import com.acabra.webapp.data.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getById(long id) {
        return roomRepository.findById(id).orElse(null);
    }
}
