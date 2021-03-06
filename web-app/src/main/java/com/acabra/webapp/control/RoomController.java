package com.acabra.webapp.control;

import com.acabra.webapp.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;
    static final String TEMPLATE_NAME = "rooms";


    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public String getAllRooms(Model model) {
        model.addAttribute(TEMPLATE_NAME, roomService.getAllRooms());
        return TEMPLATE_NAME; //template name
    }
}
