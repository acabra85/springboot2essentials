package com.acabra.webapp.service;

import com.acabra.webapp.model.Room;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class RoomService {

    private static final List<Room> rooms = new ArrayList<>();

    static {
        IntStream.range(0, 10)
            .forEach(i -> rooms.add(new Room(i, "R" + i, "name:" + i, "some info:" + i)));
    }

    public List<Room> getAllRooms() {
        return rooms;
    }

}
