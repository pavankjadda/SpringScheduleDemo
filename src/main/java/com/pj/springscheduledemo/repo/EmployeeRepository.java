package com.pj.springscheduledemo.repo;

import com.pj.springscheduledemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long>
{
}
