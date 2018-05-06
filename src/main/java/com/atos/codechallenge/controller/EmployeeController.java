package com.atos.codechallenge.controller;

import com.atos.codechallenge.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("/")
public class EmployeeController {
    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service){
        this.service = service;
    }

    @GetMapping("/")
    public ModelAndView findAll(){
        ModelAndView mav = new ModelAndView("/employees");
        mav.addObject("employees", service.listAll());
        mav.addObject("filters", service.getAvailableFilters());
        return mav;
    }



}
