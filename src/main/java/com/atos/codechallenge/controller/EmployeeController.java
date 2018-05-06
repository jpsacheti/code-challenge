package com.atos.codechallenge.controller;

import com.atos.codechallenge.model.Employee;
import com.atos.codechallenge.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class EmployeeController {
    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service){
        this.service = service;
    }


    @PostMapping(value = "/filter", consumes = APPLICATION_JSON_VALUE)
    public List<Employee> pesquisarJson(@RequestBody List<String> selectedFilters) {
        return service.filter(selectedFilters);
    }

    @GetMapping("/")
    public List<Employee> listJson() {
        return service.listAll();
    }
    
}
