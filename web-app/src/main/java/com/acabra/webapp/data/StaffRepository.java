package com.acabra.webapp.data;

import com.acabra.webapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Employee, String> {
}
