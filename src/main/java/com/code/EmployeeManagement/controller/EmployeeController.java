package com.code.EmployeeManagement.controller;

import com.code.EmployeeManagement.model.Employee;
import com.code.EmployeeManagement.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Controller
public class EmployeeController {

    @Autowired(required=true)
    private EmployeeService employeeServiceImpl;

    //index page
    @GetMapping(value = "/index")
    public ModelAndView index (){
        ModelAndView mv = new ModelAndView("index");
        return mv;  
    }

    //employeeForm page
    @GetMapping(value = "/employeeForm")
    public ModelAndView employeeForm (Model model){
        ModelAndView mv = new ModelAndView("employeeForm");
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return mv;  
    }

    @PostMapping("/addEmployee")
    public ModelAndView showEmployeeForm (
        @ModelAttribute ("employee") Employee employee)
    {
        ModelAndView mv = new ModelAndView("redirect:/employee");
        
        employeeServiceImpl.saveEmployee(employee);
        System.out.println(employee.getName());
        System.out.println(employee.getSurname());
        return mv;
    }


    //display list of employees
    @GetMapping("/employee")
    public ModelAndView displayEmployees(Model model){
        ModelAndView mv = new ModelAndView("employee");
        model.addAttribute("listEmployees", employeeServiceImpl.getAllEmployees());
        return mv;
    }
    

    //Editting an employee
    @RequestMapping(value = "/edit")
    public ModelAndView edit (){
        ModelAndView mv = new ModelAndView("edit");
        //Look up the employee from the database
        //If present, edit the data
        //update the index page
        return mv; 
    }

    //deleting an employee
    @RequestMapping(value = "/delete")
    public ModelAndView delete (){
        ModelAndView mv = new ModelAndView("delete");
        //Look up the employee from the database
        //If present, delete
        //update the index page
        return mv; 
    }
    
    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("templates/");
        resolver.setSuffix(".html");
        return resolver;
    }
    
}