package com.code.EmployeeManagement.Repository;

import com.code.EmployeeManagement.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepos extends JpaRepository<Employee,Long>
{

}
