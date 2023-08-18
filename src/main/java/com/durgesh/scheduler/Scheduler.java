package com.durgesh.scheduler;

import com.durgesh.jpa.EmployeeRepository;
import com.durgesh.model.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class Scheduler {
    @Autowired
    private EmployeeRepository  employeeRepository;

    @Scheduled(fixedRate = 5000)
    public LocalDateTime timer()
    {
        List<Employee> employeeList=employeeRepository.findAll();
        employeeList.forEach(employee -> {
            System.out.println(employee.getId());
        });
        System.out.println(LocalDateTime.now());
        return LocalDateTime.now();
    }


}
