package com.acabra.webapp.control;

import com.acabra.webapp.service.StaffService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/staff")
public class StaffController {

    final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    String getStaff(Model model) {
        model.addAttribute("staff", staffService.getAllStaff());
        return "staff";
    }
}
