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

/**
 * Main entry point to the REST webservice. Handles request for the Employee entity
 *
 * @author Joao Pedro Sacheti
 */
@RestController
public class EmployeeController {
    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service){
        this.service = service;
    }


    /**
     * @param selectedFilters to filter the skills
     * @return a filtered json with all the matching {@link Employee}s
     */
    @PostMapping(value = "/filter", consumes = APPLICATION_JSON_VALUE)
    public List<Employee> filterJson(@RequestBody List<String> selectedFilters) {
        return service.filter(selectedFilters);
    }

    /**
     * @return a {@link List} with all the {@link Employee}s
     */
    @GetMapping("/")
    public List<Employee> listJson() {
        return service.listAll();
    }

    /**
     * @return a Json with all the available skills for querying with {@link EmployeeController#filterJson(List)}
     */
    @GetMapping("/skills")
    public List<String> listSkills() {
        return service.getAvailableFilters();
    }

}
