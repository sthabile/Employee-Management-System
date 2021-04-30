package com.code.EmployeeManagement.service;

import java.util.List;

import com.code.EmployeeManagement.model.Employee;


public interface  EmployeeService {

    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployeeById(long id);
}
