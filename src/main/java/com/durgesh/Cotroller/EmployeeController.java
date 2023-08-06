package com.durgesh.Cotroller;

import com.durgesh.filter.EmployeeFilter;
import com.durgesh.jpa.EmployeeRepository;
import com.durgesh.model.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping(value = "/get/{id}")
    public Employee getEmployeeById(@PathVariable Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteEmployeeById(@PathVariable Integer id) {
        employeeRepository.deleteById(id);
        return "Deleted Successfully ";
    }


    @GetMapping(value = "/name")
    public List<Employee> getByName(EmployeeFilter employeeFilter) {
        if (!ObjectUtils.isEmpty(employeeFilter.getName()))
            return employeeRepository.findByName(employeeFilter.getName());
        else return employeeRepository.findByCompanyName(employeeFilter.getCompanyName());

    }

    @GetMapping(value = "/filter")
    public List<Employee> filter(EmployeeFilter employeeFilter) {
        List<Employee> employees = employeeRepository.findAll();
        if (!ObjectUtils.isEmpty(employeeFilter.getName()) && !ObjectUtils.isEmpty(employeeFilter.getStateName()) && !ObjectUtils.isEmpty(employeeFilter.getCompanyName()) && !ObjectUtils.isEmpty(employeeFilter.getZipCode())) {
            return employees.stream().filter(employee -> employee.getName().equalsIgnoreCase(employeeFilter.getName()) && employee.getCompanyName().equalsIgnoreCase(employeeFilter.getCompanyName()) && employee.getStateName().equalsIgnoreCase(employeeFilter.getStateName()) && employee.getZipCode().equalsIgnoreCase(employeeFilter.getZipCode())).collect(Collectors.toList());
        }
        if (!ObjectUtils.isEmpty(employeeFilter.getStateName()) && ObjectUtils.isEmpty(employeeFilter.getZipCode())) {
            return employees.stream().filter(employee -> employee.getStateName().equalsIgnoreCase(employeeFilter.getStateName())).collect(Collectors.toList());
        }
        if (!ObjectUtils.isEmpty(employeeFilter.getStateName()) && !ObjectUtils.isEmpty(employeeFilter.getZipCode())) {
            return employees.stream().filter(employee -> employee.getStateName().equalsIgnoreCase(employeeFilter.getStateName()) && employee.getZipCode().equalsIgnoreCase(employeeFilter.getZipCode())).collect(Collectors.toList());
        }

        if (!ObjectUtils.isEmpty(employeeFilter.getName()))
            return employeeRepository.findByName(employeeFilter.getName());
        else return employeeRepository.findByCompanyName(employeeFilter.getCompanyName());

    }

    @GetMapping(value = "/array")
    public List<Integer> integerTypeValue(EmployeeFilter employeeFilter) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(100);
        integers.add(200);
        integers.add(1);
        integers.add(230);
        integers.add(250);
        integers.add(20);
        integers.add(2000);

        if (ObjectUtils.isEmpty(employeeFilter.isAscending()))
            return integers.stream().sorted().collect(Collectors.toList());
        else return integers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    @GetMapping(value = "/string")
    public List<String> stringTypeValue(EmployeeFilter employeeFilter) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("AMIT");
        strings.add("ANIl");
        strings.add("Durgesh");
        strings.add("Yogesh");
        strings.add("Brijesh");
        strings.add("Zaze");
        strings.add("Randome");


        if (employeeFilter.isAscending()) return strings.stream().sorted().collect(Collectors.toList());
        else return strings.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    @DeleteMapping(value = "/delete")
    public String deleteFilter(EmployeeFilter employeeFilter) {
        List<Employee> collect = null;
        List<Employee> employees = employeeRepository.findAll();
        if (employeeFilter.isDelete() && !ObjectUtils.isEmpty(employeeFilter.getZipCode())) {
            collect = employees.stream().filter(employee -> {
                if (employeeFilter.isDelete() && employee.getZipCode().equalsIgnoreCase(employeeFilter.getZipCode())) {
                    employeeRepository.deleteById(employee.getId());
                }
                return false;
            }).collect(Collectors.toList());
        }
        if (ObjectUtils.isEmpty(collect)) {
            return "Record Deleted";
        }
        return "Not Deleted";
    }

}
