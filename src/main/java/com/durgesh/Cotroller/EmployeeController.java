package com.durgesh.Cotroller;

import com.durgesh.filter.EmployeeFilter;
import com.durgesh.jpa.EmployeeRepository;
import com.durgesh.model.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;

    }

    @PostMapping
    public Employee getEmployee(@RequestBody Employee employee) {
        employee.setCreateDate(LocalDateTime.now());
        employee.setCreatedBy("Durgesh Yadav");
        employee.setUpdateDate(LocalDateTime.now());
        employee = employeeRepository.save(employee);
        return employee;
    }

    @GetMapping
    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }


    @GetMapping(value = "/name")
    public List<Employee> getByName(EmployeeFilter employeeFilter) {
        if (!ObjectUtils.isEmpty(employeeFilter.getName()))
            return employeeRepository.findByName(employeeFilter.getName());
        else return employeeRepository.findByCompanyName(employeeFilter.getCompanyName());

    }



}
