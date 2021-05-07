package com.code.EmployeeManagement.service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Employee getEmployee(long id) {
        Optional<Employee> optional = employeeRespository.findById(id);
        Employee employee = null;
        if(optional.isPresent())
        {
            employee = optional.get();
        }
        else{
            throw new RuntimeException("Employee not found for id : " + id);
        }
        return employee;
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRespository.deleteById(id);
    }

}
