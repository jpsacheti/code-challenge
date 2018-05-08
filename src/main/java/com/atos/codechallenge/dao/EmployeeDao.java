package com.atos.codechallenge.dao;

import com.atos.codechallenge.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Main source of data of the Application
 *
 * @author Joao Pedro
 */
@Repository
public class EmployeeDao {

    private static List<Employee> mockData;

    /**
     * Method triggered by the app startup. It'll fill the data from the provided Json to serve as a repository to the app
     * Failure parse the data will cause the app to crash at startup.
     *
     * @throws IOException if the file is not found.
     */
    @EventListener(ApplicationReadyEvent.class)
    public void fillWithTestData() throws IOException {
        final InputStream json = new ClassPathResource("employees.json").getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules(); //Register the JSR-310 plug-in for java.time parsing
        mockData = Arrays.asList(mapper.readValue(json, Employee[].class));
    }

    /**
     * @return a immutable copy of the underlying list of the {@link Employee}s.
     */
    public List<Employee> listAll() {
        return Collections.unmodifiableList(new ArrayList<>(mockData));
    }
}
