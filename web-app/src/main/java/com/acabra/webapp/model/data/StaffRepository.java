package com.acabra.webapp.model.data;

import com.acabra.webapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Employee, String> {
}
