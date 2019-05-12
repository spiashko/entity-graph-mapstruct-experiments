package com.siarhei.jpatransactionaldemo.employee.impl;

import com.siarhei.jpatransactionaldemo.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Long, Employee> {
}
