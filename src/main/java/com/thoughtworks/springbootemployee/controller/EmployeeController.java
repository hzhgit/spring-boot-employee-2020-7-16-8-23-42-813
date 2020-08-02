package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping
    public List<Employee> getAllEmployees(){
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1,"zach",18,"male"));
        employees.add(new Employee(2,"karen",18,"female"));
        employees.add(new Employee(3,"york",19,"male"));
        employees.add(new Employee(4,"green",19,"male"));
        employees.add(new Employee(5,"chris",20,"male"));
        employees.add(new Employee(6,"alex",21,"female"));
        return employees;
    }
}
