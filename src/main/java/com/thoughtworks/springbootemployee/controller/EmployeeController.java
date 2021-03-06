package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> initData() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "zach", 18, "male"));
        employees.add(new Employee(2, "karen", 18, "female"));
        employees.add(new Employee(3, "york", 19, "male"));
        employees.add(new Employee(4, "green", 19, "male"));
        employees.add(new Employee(5, "chris", 20, "male"));
        employees.add(new Employee(6, "alex", 21, "female"));
        return  employees;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return initData();
    }

    @DeleteMapping("/{id}")
    public Employee deleteEmployee(@PathVariable Integer id){
        List<Employee> employees = initData();
        Employee deletedEmployee = employees.stream().filter(employee->{
            return employee.getId() == id;
        }).findFirst().orElse(null);
        return deletedEmployee;
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee addEmployee){
        List<Employee> employees = initData();
        employees.add(addEmployee);
        Employee returnEmployee = employees.stream().filter(employee->{
            return employee.getName() == addEmployee.getName();
        }).findFirst().orElse(null);
        return returnEmployee;
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Integer id ,@RequestBody Employee updateEmployee){
        List<Employee> employees = initData();
        for (int index = 0; index < employees.size(); index++) {
            if(employees.get(index).getId() == id){
                employees.set(index,updateEmployee);
            }
        }
        Employee returnEmployee = employees.stream().filter(employee->{
            return employee.getName() == updateEmployee.getName();
        }).findFirst().orElse(null);
        return returnEmployee;
    }
}
