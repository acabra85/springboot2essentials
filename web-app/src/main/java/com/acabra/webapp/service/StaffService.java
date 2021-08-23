package com.acabra.webapp.service;

import com.acabra.webapp.model.Employee;
import com.acabra.webapp.model.JobPosition;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;

@Service
public class StaffService {

    final Random r = new Random();

    public List<Employee> getAllStaff() {
        List<Employee> emps = new ArrayList<>();
        IntStream.range(0, 10)
                .mapToObj(i -> new Employee(UUID.randomUUID().toString(), "N_" + i, "L_" + i,
                        JobPosition.getPositionById(Math.abs(r.nextInt())%4).toString()))
                .forEach(emps::add);
        return emps;
    }
}
