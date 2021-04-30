package com.code.EmployeeManagement.service;

import java.util.List;

import com.code.EmployeeManagement.Repository.EmployeeRepos;
import com.code.EmployeeManagement.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("employeeService")
public class EmployeeServiceImp implements EmployeeService{

    @Autowired(required=true)
    private EmployeeRepos employeeRespository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRespository.findAll(); 
    }

    @Override
    public void saveEmployee(Employee employee) {
        this.employeeRespository.save(employee);
    }
}
