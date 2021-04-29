package com.code.EmployeeManagement.controllers;

import com.code.EmployeeManagement.models.Employee;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Controller
public class EmployeeController {
    //Initialise the object
    @ModelAttribute (value = "employee")
    public Employee newEmployee(){
        return new Employee();
    }

    //index page
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index (Model model){
        ModelAndView mv = new ModelAndView("index");
        return mv;  
    }

    //Adding an employee
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public ModelAndView add (
        @ModelAttribute(value = "employee") Employee employee,
        @RequestParam(required = false) String name, 
        @RequestParam(required = false) String surname,
        @RequestParam(required = false) Long id
    ){
        ModelAndView mv = new ModelAndView("add");
        //Create an employee.
        //first check if parameters are null
        //Add employee to database
        //update the index page

        employee = new Employee(name, surname);
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

    @RequestMapping(value = "/employee")
    public ModelAndView employeeDisplayer (){
        ModelAndView mv = new ModelAndView("employee");
        //display employees
        return mv; 
    }
    
    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("templates/");
        //resolver.setSuffix(".html");
        return resolver;
    }
    
}