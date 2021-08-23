package com.acabra.webapp.control.rest;

import com.acabra.webapp.model.Employee;
import com.acabra.webapp.service.StaffService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffRestController {
    private final StaffService staffService;

    public StaffRestController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    private List<Employee> getAllStaff(StaffService staffService) {
        return staffService.getAllStaff();
    }
}
