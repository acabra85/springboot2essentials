package com.acabra.webapp.async;

import com.acabra.webapp.model.Room;
import com.acabra.webapp.service.RoomService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RoomCleanerListener {
    private final static Logger logger = LoggerFactory.getLogger(RoomCleanerListener.class);

    private final ObjectMapper mapper;
    private final RoomService roomService;

    public RoomCleanerListener(ObjectMapper mapper, RoomService roomService) {
        this.mapper = mapper;
        this.roomService = roomService;
    }

    public void receiveMessage(String message) {
        try {
            AsyncPayload payload = mapper.readValue(message, AsyncPayload.class);
            if("ROOM".equals(payload.getModel())) {
                Room room = roomService.getById(payload.getId());
                logger.info("Room {}:{} needs to be claened", room.getNumber(), room.getName());
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
}
