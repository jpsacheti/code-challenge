package com.atos.codechallenge.dao;

import com.atos.codechallenge.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class EmployeeDao {

    private static List<Employee> mockData;

    @EventListener(ApplicationReadyEvent.class)
    public void fillWithTestData() throws IOException {
        final InputStream json = Files.newInputStream(Paths.get("employees.json"));
        ObjectMapper mapper = new ObjectMapper();
        mockData = Arrays.asList(mapper.readValue(json, Employee[].class));
    }

    public List<Employee> listAll(){
        List<Employee> safeCopy = new ArrayList<>();
        Collections.copy(safeCopy, mockData);
        return safeCopy;
    }
}
