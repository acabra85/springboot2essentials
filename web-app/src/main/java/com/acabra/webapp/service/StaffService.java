package com.acabra.webapp.service;

import com.acabra.webapp.model.Employee;
import com.acabra.webapp.model.data.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StaffService {

    private final StaffRepository staffService;

    public StaffService(StaffRepository staffService) {
        this.staffService = staffService;
    }

    public List<Employee> getAllStaff() {
        return staffService.findAll();
    }
}
