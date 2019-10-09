package com.pj.springscheduledemo.web;

import com.pj.springscheduledemo.model.Employee;
import com.pj.springscheduledemo.repo.EmployeeRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/employee")
public class EmployeeController
{
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping(value = "/list")
    public List<Employee> findAll()
    {
        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));
    }

    @GetMapping(value = "/find/{id}")
    public Optional<Employee> findById(@PathVariable Long id)
    {
        return employeeRepository.findById(id);
    }

    @GetMapping(value = "/create")
    public Employee findById()
    {
        return employeeRepository.saveAndFlush(new Employee());
    }
}
