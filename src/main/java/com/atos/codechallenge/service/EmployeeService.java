package com.atos.codechallenge.service;

import com.atos.codechallenge.dao.EmployeeDao;
import com.atos.codechallenge.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeDao dao;

    @Autowired
    public EmployeeService(EmployeeDao dao) {
        this.dao = dao;
    }

    public List<Employee> filter(List<String> filters) {
        return dao.listAll()
                .stream()
                .filter(employee -> employee.getSkills().stream()
                        .anyMatch(filters::contains))
                .collect(Collectors.toList());
    }

    public List<Employee> listAll() {
        return dao.listAll();
    }

    public List<String> getAvailableFilters() {
        return listAll().stream()
                .flatMap(e -> e.getSkills().stream())
                .distinct()
                .collect(Collectors.toList());
    }
}
